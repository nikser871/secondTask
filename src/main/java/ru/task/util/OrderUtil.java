package main.java.ru.task.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Утилитный класс для работы с заказами
 */
public final class OrderUtil {

    /**
     * Возвращает строку с подсчитанным количеством продуктов
     *
     * @param products список продуктов
     * @return строка для запись в файл с подсчетом количества
     */
    public static String getProductsWithCounting(List<String> products) {
        Map<String, Integer> map = products.stream()
                .collect(Collectors.groupingBy(name ->
                        name, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() != 1)
                result.append(" x").append(entry.getValue());
        }

        return result.toString();
    }

}
