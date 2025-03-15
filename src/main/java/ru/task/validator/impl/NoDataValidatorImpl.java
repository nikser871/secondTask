package main.java.ru.task.validator.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.OrderException;
import main.java.ru.task.validator.Validator;

import java.util.function.Predicate;

import static main.java.ru.task.entity.enums.ErrorStatus.NO_ADDRESS_DATA;
import static main.java.ru.task.entity.enums.ErrorStatus.NO_PHONE_DATA;

/**
 * Реализация валидатора для проверки на отсутствие данных (либо номера телефона, либо адреса)
 */
public class NoDataValidatorImpl implements Validator<Order> {

    Predicate<Order> testPhone = order -> order.phoneNumber().isBlank() || order.phoneNumber().isEmpty();
    Predicate<Order> testAddress = order -> order.address().isBlank() || order.address().isEmpty();

    @Override
    public boolean isValid(Order order) throws OrderException {
        if (testAddress.test(order)) {
            throw new OrderException("Не указан адрес!", NO_ADDRESS_DATA);
        } else if (testPhone.test(order)) {
            throw new OrderException("Не указан номер телефона!", NO_PHONE_DATA);
        }

        return true;
    }
}
