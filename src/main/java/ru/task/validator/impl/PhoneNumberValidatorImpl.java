package main.java.ru.task.validator.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.NotValidPhoneNumberException;
import main.java.ru.task.validator.Validator;

import java.util.regex.Pattern;

/**
 * Реализация валидатора для проверки номера телефона, указанного в заказе
 */
public class PhoneNumberValidatorImpl implements Validator<Order> {

    Pattern pattern = Pattern.compile("\\+\\d-\\d{3}-\\d{3}-\\d{2}-\\d{2}");

    @Override
    public boolean isValid(Order order) throws NotValidPhoneNumberException {
        if (pattern.matcher(order.phoneNumber()).matches())
            return true;
        else
            throw new NotValidPhoneNumberException("Неверный формат у номера телефона!");
    }
}
