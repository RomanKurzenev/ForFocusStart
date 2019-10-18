package ru.myproject.files;

import ru.myproject.area.AreaChecker;
import ru.myproject.triangle.TriangleTop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Реализация менеджера для чтения входных данных и записи выходных.
 *
 * @author Роман Курзенев
 * @since 16.10.2019
 */
public class FileManagerImpl implements FileManager {

    /**
     * Минимальное колличество символов в строке, в которые можно записать координаты треугольника через пробел.
     */
    private static final int MIN_LINE_LENGTH = 11;

    /**
     * Необходимое число координат в строке.
     */
    private static final int NUMBER_OF_COORDINATES = 6;

    /**
     * Файл с входными данными.
     */
    private final File inputFile;

    /**
     * Файл с выходными данными.
     */
    private final File outputFile;

    /**
     * Проверяльщик площади треугольников.
     */
    private final AreaChecker areaChecker;

    public FileManagerImpl(File inputFile, File outputFile, AreaChecker areaChecker) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.areaChecker = areaChecker;
    }

    /**
     * Считать данные из файла построчно.
     */
    @Override
    public void readLines() {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                lineCheck(line);
            }
        } catch (IOException e) {
            System.out.println("File " + inputFile.toString() + " not found");
        }
    }

    /**
     * Запись результата в файл.
     *
     * @param triangleTops вершины треугольника
     */
    @Override
    public void writeResult(List<TriangleTop> triangleTops) {
        try (FileWriter fileWriter = new FileWriter(outputFile, false)) {
            if (triangleTops != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (TriangleTop i : triangleTops) {
                    stringBuilder.append(i.getX()).append(" ");
                    stringBuilder.append(i.getY()).append(" ");
                }
                fileWriter.write(stringBuilder.toString());
            } else {
                System.out.println("In " + inputFile.toString() + " no coordinates satisfying conditions");
                fileWriter.write(" ");
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing in output file " + outputFile.toString());
        }
    }

    /**
     * Проверка корректности координат.
     *
     * @param line строка, содержащая координаты вершин треугольника
     */
    private void lineCheck(String line) {
        if (line.length() >= MIN_LINE_LENGTH) {
            try {
                int[] coordinates = Pattern.compile("\\s")
                        .splitAsStream(line.trim())
                        .mapToInt(Integer::valueOf)
                        .toArray();
                if (coordinates.length == NUMBER_OF_COORDINATES) {
                    List<TriangleTop> triangleTops = new ArrayList<>();
                    triangleTops.add(new TriangleTop(coordinates[0], coordinates[1]));
                    triangleTops.add(new TriangleTop(coordinates[2], coordinates[3]));
                    triangleTops.add(new TriangleTop(coordinates[4], coordinates[5]));
                    areaChecker.checkArea(triangleTops);
                }
            } catch (NumberFormatException e) {
                // пропускаем обработку строки, т. к. не смогли распарсить числа
            }
        }
    }
}
