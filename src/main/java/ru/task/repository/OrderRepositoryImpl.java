package main.java.ru.task.repository;

import main.java.ru.task.entity.Order;
import main.java.ru.task.mapper.Mapper;
import main.java.ru.task.mapper.impl.MapperImpl;

import java.io.*;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    Mapper mapper;

    public OrderRepositoryImpl(Mapper mapper) {
        this.mapper = new MapperImpl();
    }

    @Override
    public List<Order> readOrdersFromInputStream(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .map(mapper::toEntity)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка во время чтения файла!", e);
        }
    }

    @Override
    public void writeOrdersToOutputStream(OutputStream outputStream, List<String> orders) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            orders.stream()
                    .forEach(csq -> {
                        try {
                            writer.append(csq);
                        } catch (IOException e) {
                            throw new RuntimeException("Произошла ошибка во время записи в файл!", e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка во время записи в файл!", e);
        }
    }
}
