package main.java.ru.task.mapper.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.mapper.Mapper;

public class MapperImpl implements Mapper {

    @Override
    public Order toEntity(String rowData) {
        return null;
    }

    @Override
    public String toRowData(Order order) {
        return "";
    }

}
