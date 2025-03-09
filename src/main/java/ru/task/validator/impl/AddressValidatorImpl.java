package main.java.ru.task.validator.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.NotValidAddressException;
import main.java.ru.task.validator.Validator;

import java.util.regex.Pattern;

/**
 * Реализация валидатора для проверки адреса, указанного в заказе
 */
public class AddressValidatorImpl implements Validator<Order> {

    Pattern pattern = Pattern.compile("^[А-Яа-яЁё\\s-]+\\.\\s[А-Яа-яЁё\\s-]+\\.\\s[А-Яа-яЁё\\s-]+\\.\\s[А-Яа-яЁё\\s-]+$");

    @Override
    public boolean isValid(Order order) throws NotValidAddressException {
        if (pattern.matcher(order.address()).matches())
            return true;
        else
            throw new NotValidAddressException("Указан неверный адрес в заказе!");
    }
}
