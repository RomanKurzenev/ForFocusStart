package ru.myproject;

import ru.myproject.area.AreaChecker;
import ru.myproject.area.AreaCheckerImpl;
import ru.myproject.files.FileManager;
import ru.myproject.files.FileManagerImpl;

import java.io.File;

/**
 * Приложение для поиска наибольшего по площади равнобедренного треугольника.
 *
 * @author Роман Курзенев
 * @since 10.10.2019
 */
public class Application {

    /**
     * Необходимое число аргументов для запуска приложения.
     */
    private static final int NUMBER_OF_ARGUMENTS = 2;

    public static void main(String[] args) {
        if (args.length >= NUMBER_OF_ARGUMENTS) {
            File in = new File(args[0]);
            File out = new File(args[1]);

            AreaChecker areaChecker = new AreaCheckerImpl();
            FileManager fileManager = new FileManagerImpl(in, out, areaChecker);
            fileManager.readLines();
            fileManager.writeResult(areaChecker.getMaxTriangleTops());
        } else {
            System.out.println("Name input or output file not entered");
        }
    }
}