package main.java.ru.task.service;

import main.java.ru.task.entity.Order;

import java.util.List;

/**
 * Интерфейс для работы с заказами
 */
public interface IOrderService {

    /**
     * Создать заполненный файл
     *
     * @param fileName имя файла
     * @param content данные
     */
    void createFileWithContent(String fileName, List<String> content);

    /**
     * Прочитать данные о заказах из файла
     *
     * @param fileName Имя файла
     */
    List<Order> readFile(String fileName);

    /**
     *
     */
}
