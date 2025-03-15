package main.java.ru.task.entity;

import main.java.ru.task.entity.enums.Priority;

import java.util.List;

/**
 * Сущность заказа
 *
 * @param order номер заказа
 * @param products продукты
 * @param fio ФИО заказчика
 * @param address адрес
 * @param phoneNumber телефон
 * @param priority приоритетность
 */
public record Order(int order,
                    List<String> products,
                    String fio,
                    String address,
                    String phoneNumber,
                    Priority priority) {
}
