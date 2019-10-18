package ru.myproject.area;

import ru.myproject.exception.TriangleNotExistException;
import ru.myproject.triangle.Triangle;
import ru.myproject.triangle.TriangleTop;

import java.util.List;

/**
 * Реализация проверяльщика площади треугольников.
 *
 * @author Роман Курзенев
 * @since 16.10.2019
 */
public class AreaCheckerImpl implements AreaChecker {

    /**
     * Максимальная площадь.
     */
    private double maxArea = 0;

    /**
     * Вершины треугольника с максимальной площадью.
     */
    private List<TriangleTop> maxTriangleTops;

    @Override
    public void checkArea(List<TriangleTop> triangleTops) {
        try {
            Triangle triangle = getTriangle(triangleTops);
            double area = triangle.calculateArea();
            if (area > maxArea) {
                maxArea = area;
                maxTriangleTops = triangleTops;
            }
        } catch (TriangleNotExistException e) {
            //пропускаем вычисление площади т.к. треугольник не существует
        }
    }

    @Override
    public List<TriangleTop> getMaxTriangleTops() {
        return maxTriangleTops;
    }

    /**
     * Получить треугольник с известными длинами сторон.
     *
     * @param triangleTops вершины треугольника
     * @return треугольник с известными длинами сторон
     */
    private Triangle getTriangle(List<TriangleTop> triangleTops) {
        TriangleTop firstTop = triangleTops.get(0);
        TriangleTop secondTop = triangleTops.get(1);
        TriangleTop thirdTop = triangleTops.get(2);
        double a = getSideLength(firstTop, secondTop);
        double b = getSideLength(secondTop, thirdTop);
        double c = getSideLength(firstTop, thirdTop);
        return new Triangle(a, b, c);
    }

    /**
     * Получить длину стороны по известным вершинам.
     *
     * @param oneTop     одна вершина
     * @param anotherTop другая вершина
     * @return длина стороны
     */
    private double getSideLength(TriangleTop oneTop, TriangleTop anotherTop) {
        return Math.sqrt(Math.pow(anotherTop.getX() - oneTop.getX(), 2)
                + Math.pow(anotherTop.getY() - oneTop.getY(), 2));
    }
}
