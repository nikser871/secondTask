package main.java.ru.task.mapper;

import main.java.ru.task.entity.Order;

/**
 * Маппер
 */
public interface Mapper {

    Order toEntity(String rowData);

    String toRowData(Order order);

}
