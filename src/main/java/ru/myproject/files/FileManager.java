package ru.myproject.files;

import ru.myproject.triangle.TriangleTop;

import java.util.List;

/**
 * Менеджер для чтения входных данных и записи выходных.
 *
 * @author Роман Курзенев
 * @since 16.10.2019
 */
public interface FileManager {

    /**
     * Считать данные.
     */
    void readLines();

    /**
     * Вывести набор вершин в файл.
     *
     * @param triangleTops набор вершин равнобедренного треугольника с максимальной площадью
     */
    void writeResult(List<TriangleTop> triangleTops);
}
