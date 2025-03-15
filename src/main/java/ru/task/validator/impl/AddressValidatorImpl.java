package main.java.ru.task.validator.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.OrderException;
import main.java.ru.task.validator.Validator;

import java.util.regex.Pattern;

import static main.java.ru.task.entity.enums.ErrorStatus.NOT_VALID_ADDRESS;
import static main.java.ru.task.util.OrderUtil.isBlankOrEmpty;

/**
 * Реализация валидатора для проверки адреса, указанного в заказе
 */
public class AddressValidatorImpl implements Validator<Order> {

    Pattern pattern = Pattern.compile("^[А-Яа-яЁё\\s-]+\\.\\s[А-Яа-яЁё\\s-]+\\.\\s[А-Яа-яЁё\\s-]+\\.\\s[А-Яа-яЁё\\s-]+$");

    @Override
    public boolean isValid(Order order) throws OrderException {
        if (pattern.matcher(order.address()).matches())
            return true;
        else if (!isBlankOrEmpty(order.address()))
            throw new OrderException("Указан неверный адрес в заказе!", NOT_VALID_ADDRESS);

        return false;
    }
}
