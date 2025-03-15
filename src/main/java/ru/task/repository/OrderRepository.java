package main.java.ru.task.repository;

import main.java.ru.task.entity.Order;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Репозиторий для работы с заказами
 */
public interface OrderRepository {

    /**
     * Получить список заказов
     *
     * @param inputStream поток на чтение
     * @return список заказов
     */
    List<Order> readOrdersFromInputStream(InputStream inputStream);

    /**
     * Записать в файл список успешных заказов
     *
     * @param outputStream поток на запись
     * @param orders успешные заказы
     */
    void writeSuccessOrdersToOutputStream(OutputStream outputStream, List<Order> orders);

    /**
     * Записать в файл список неудачных заказов
     *
     * @param outputStream поток на запись
     * @param orders заказы с ошибкой
     */
    void writeErrorOrdersToOutputStream(OutputStream outputStream, List<Order> orders);

}
