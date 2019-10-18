package ru.myproject.area;

import ru.myproject.triangle.TriangleTop;

import java.util.List;

/**
 * Проверяльщик площади треугольников.
 *
 * @author Роман Курзенев
 * @since 16.10.2019
 */
public interface AreaChecker {

    /**
     * Проверить площадь треугольника по данным вершинам.
     *
     * @param triangleTops полученные вершины треугольника
     */
    void checkArea(List<TriangleTop> triangleTops);

    /**
     * Получить вершины равнобедренного треугольника с максимальной площадью.
     *
     * @return вершины треугольника
     */
    List<TriangleTop> getMaxTriangleTops();
}
