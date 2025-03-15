package main.java.ru.task;

import main.java.ru.task.mapper.impl.MapperImpl;
import main.java.ru.task.repository.OrderRepository;
import main.java.ru.task.repository.OrderRepositoryImpl;
import main.java.ru.task.service.IOrderService;
import main.java.ru.task.service.OrderServiceImpl;
import main.java.ru.task.util.PropertyUtil;


public class Main {
    public static void main(String[] args) {
        String fileName = PropertyUtil.get("order-file.path");

        OrderRepository repository = new OrderRepositoryImpl(new MapperImpl());
        IOrderService ioService = new OrderServiceImpl(repository, new MapperImpl());
        ioService.processOrders(fileName);
    }
}