package main.java.ru.task.mapper.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.entity.enums.Priority;
import main.java.ru.task.mapper.Mapper;
import main.java.ru.task.util.OrderUtil;

import java.util.Arrays;

import static main.java.ru.task.util.OrderUtil.getProductsWithCounting;

public class MapperImpl implements Mapper {

    @Override
    public Order toEntity(String rowData) {
        String[] data = rowData.split(";");
        return new Order(Integer.parseInt(data[0]),
                Arrays.stream(data[1].split(",")).map(String::trim).toList(),
                data[2],
                data[3],
                data[4],
                Priority.valueOf(data[5]));
    }

    @Override
    public String toRowData(Order order) {
        return order.order() + ";"
                + getProductsWithCounting(order.products()) + ";"
                + order.fio() + ";"
                + order.address() + ";"
                + order.phoneNumber() + ";"
                + order.priority();
    }

}
