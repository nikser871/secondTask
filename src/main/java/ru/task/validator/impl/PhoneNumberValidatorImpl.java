package main.java.ru.task.validator.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.OrderException;
import main.java.ru.task.validator.Validator;

import java.util.regex.Pattern;

import static main.java.ru.task.entity.enums.ErrorStatus.NOT_VALID_PHONE;

/**
 * Реализация валидатора для проверки номера телефона, указанного в заказе
 */
public class PhoneNumberValidatorImpl implements Validator<Order> {

    Pattern pattern = Pattern.compile("\\+\\d-\\d{3}-\\d{3}-\\d{2}-\\d{2}");

    @Override
    public boolean isValid(Order order) throws OrderException {
        if (pattern.matcher(order.phoneNumber()).matches())
            return true;
        else
            throw new OrderException("Неверный формат у номера телефона!", NOT_VALID_PHONE);
    }
}
