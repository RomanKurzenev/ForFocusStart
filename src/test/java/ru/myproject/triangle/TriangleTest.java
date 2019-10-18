package ru.myproject.triangle;

import org.junit.Test;
import ru.myproject.exception.TriangleNotExistException;

import static org.junit.Assert.assertEquals;

/**
 * Тесты на {@link Triangle}.
 *
 * @author Роман Курзенев
 * @since 16.10.2019
 */
public class TriangleTest {

    /**
     * Тест на выбрасывание исключения при значениях длин сторон, из которых нельзя построить треугольник.
     */
    @Test(expected = TriangleNotExistException.class)
    public void isTriangleExist() {
        new Triangle(1.0, 1.0, 4.0);
    }

    /**
     * Тест на расчет площади равнобедренного треугольника, боковые стороны которого больше основания.
     */
    @Test
    public void calculateArea1Long2Short() {
        Triangle triangle = new Triangle(1.0, 1.0, 1.4142135623730951);
        assertEquals(0.49999999999999983, triangle.calculateArea(), 0.0000000000000001);
    }

    /**
     * Тест на расчет площади равнобедренного треугольника, боковые стороны которого больше основания.
     */
    @Test
    public void calculateArea2Long1Short() {
        Triangle triangle = new Triangle(4.47213595499958, 4.47213595499958, 4.0);
        assertEquals(8.0, triangle.calculateArea(), 0.0000000000000001);
    }

    /**
     * Тест на расчет площади треугольника, не являющегося равнобедренным. Значение площади устанавливается равным 0.
     */
    @Test
    public void calculateAreaNotIsosceles() {
        Triangle triangle = new Triangle(10.0, 4.0, 10.770329614269007);
        assertEquals(0.0, triangle.calculateArea(), 0.0000000000000001);
    }
}