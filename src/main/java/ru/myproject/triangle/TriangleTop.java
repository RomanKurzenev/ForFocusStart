package ru.myproject.triangle;

import java.util.Objects;

/**
 * Вершина треугольника.
 *
 * @author Роман Курзенев
 * @since 10.10.2019
 */
public class TriangleTop {

    /**
     * Абсцисса вершины.
     */
    private final long x;

    /**
     * Ордината вершины.
     */
    private final long y;

    /**
     * Конструктор вершины треугольника.
     *
     * @param x абсцисса
     * @param y ордината
     */
    public TriangleTop(long x, long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получить абсциссу вершины.
     *
     * @return абсцисса
     */
    public long getX() {
        return x;
    }

    /**
     * Получить ординату вершины.
     *
     * @return ордината
     */
    public long getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleTop that = (TriangleTop) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "ru.myproject.triangle.TriangleTop{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
