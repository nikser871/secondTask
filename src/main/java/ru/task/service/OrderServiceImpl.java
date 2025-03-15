package main.java.ru.task.service;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.OrderException;
import main.java.ru.task.mapper.Mapper;
import main.java.ru.task.repository.OrderRepository;
import main.java.ru.task.util.OrderUtil;
import main.java.ru.task.validator.Validator;
import main.java.ru.task.validator.impl.AddressValidatorImpl;
import main.java.ru.task.validator.impl.NoDataValidatorImpl;
import main.java.ru.task.validator.impl.PhoneNumberValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements IOrderService {

    private final String PATH = "src/main/resources/";
    private final String ORDER = "order_";
    private final String NO_DATA_FILE_PATH = PATH + "non_valid_orders.txt";
    OrderRepository orderRepository;
    Mapper mapper;
    private final List<Validator<Order>> validators;

    public OrderServiceImpl(OrderRepository orderRepository, Mapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;

        this.validators = new ArrayList<>();
        validators.add(new PhoneNumberValidatorImpl());
        validators.add(new AddressValidatorImpl());
        validators.add(new NoDataValidatorImpl());
    }

    @Override
    public void createFilesWithContent(String fileName, List<String> content) {
        try {
            Path path = Path.of(fileName);
            if (Files.exists(path))
                Files.delete(path);

            orderRepository.writeOrdersToOutputStream(Files.newOutputStream(path), content);
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка во время записи в файл!", e);
        }
    }

    @Override
    public List<Order> readFile(String fileName) {
        try {
            return orderRepository.readOrdersFromInputStream(Files.newInputStream(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка во время чтения из файла!", e);
        }
    }

    @Override
    public void processOrders(String fileName) {
        List<Order> orders = readFile(fileName);
        List<String> noValidOrders = new ArrayList<>();
        Map<String, List<Order>> validOrders;

        validOrders = orders.stream()
                .filter(order -> {
                    List<OrderException> exceptions = new ArrayList<>();
                    for (Validator<Order> validator : validators) {
                        try {
                            validator.isValid(order);
                        } catch (OrderException e) {
                            exceptions.add(e);
                        }
                    }

                    if (!exceptions.isEmpty()) {
                        exceptions.forEach(e -> {
                            noValidOrders.add(OrderUtil.getPresentationOfFailedOrder(order, e.getStatus()));
                        });

                        return false;
                    }
                    return true;
                })
                .collect(Collectors.groupingBy(OrderUtil::getCountryFromOrder,
                        Collectors.collectingAndThen(Collectors.mapping(order -> order, Collectors.toList()),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(OrderUtil::getCountryFromOrder).thenComparing(Order::priority))
                                        .toList())));

        createFilesWithContent(NO_DATA_FILE_PATH, noValidOrders);

        validOrders.forEach((key, value) -> {
            List<String> ord = value.stream()
                    .map(mapper::toRowData)
                    .toList();

            createFilesWithContent(PATH + ORDER + key + ".txt", ord);
        });
    }
}
