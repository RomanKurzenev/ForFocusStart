package ru.myproject.exception;

/**
 * Исключение при невозможности построить треугольник по данным трём вершинам.
 *
 * @author Роман Курзенев
 * @since 15.10.2019
 */
public class TriangleNotExistException extends RuntimeException {

    public TriangleNotExistException() {
        super();
    }
}
