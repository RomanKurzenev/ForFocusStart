package ru.myproject.triangle;

import ru.myproject.exception.TriangleNotExistException;

import java.util.Objects;

/**
 * Треугольник с известными длинами сторон.
 *
 * @author Роман Курзенев
 * @since 10.10.2019
 */
public class Triangle {

    /**
     * Первая сторона треугольника.
     */
    private final double firstSide;

    /**
     * Вторая сторона треугольника.
     */
    private final double secondSide;

    /**
     * Третья сторона треугольника.
     */
    private final double thirdSide;

    /**
     * Конструктор треугольника с проверкой на существаование треугольника.
     *
     * @param firstSide  первая сторона
     * @param secondSide вторая сторона
     * @param thirdSide  третья сторона
     */
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        if (!isTriangleExist(firstSide, secondSide, thirdSide)) {
            throw new TriangleNotExistException();
        }
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    /**
     * Существует ли треугольник при данных длинах сторон.
     *
     * @param firstSide  первая сторона
     * @param secondSide вторая сторона
     * @param thirdSide  третья сторона
     * @return {@code true} - если существует
     */
    private static boolean isTriangleExist(double firstSide, double secondSide, double thirdSide) {
        return firstSide + secondSide > thirdSide
                && firstSide + thirdSide > secondSide
                && secondSide + thirdSide > firstSide;
    }

    /**
     * Вычисление площади треугольника.
     *
     * @return площадь треугольника
     */
    public double calculateArea() {
        double area;

        if (!isTriangleIsosceles()) {
            area = 0;
        } else {
            double halfPerimeter = (firstSide + secondSide + thirdSide) / 2;
            area = Math.sqrt(halfPerimeter *
                    (halfPerimeter - firstSide) *
                    (halfPerimeter - secondSide) *
                    (halfPerimeter - thirdSide));
            System.out.println("Long sides ab " + firstSide);
            System.out.println("Long sides ac " + secondSide);
            System.out.println("Long sides bc " + thirdSide);
            System.out.println("Area " + area);
        }
        return area;
    }

    /**
     * Является ли треугольник равнобедренным.
     *
     * @return {@code true} - если треугольник равнобедренный
     */
    private boolean isTriangleIsosceles() {
        return firstSide == secondSide
                || secondSide == thirdSide
                || firstSide == thirdSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.firstSide, firstSide) == 0 &&
                Double.compare(triangle.secondSide, secondSide) == 0 &&
                Double.compare(triangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }

    @Override
    public String toString() {
        return "ru.myproject.triangle.Triangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                '}';
    }
}
