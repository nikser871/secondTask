package main.java.ru.task.entity;

/**
 * Сущность плохого заказа (с ошибками)
 *
 * @param order номер заказа
 * @param typeOfError тип ошибки
 * @param reason причина
 */
public record BadOrder(int order,
                       int typeOfError,
                       String reason) {
}
