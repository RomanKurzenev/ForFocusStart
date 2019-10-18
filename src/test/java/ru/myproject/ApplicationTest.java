package ru.myproject;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Тесты на {@link Application}.
 *
 * @author Роман Курзенев
 * @since 09.10.2019
 */
public class ApplicationTest {

    private static final String INPUT_PATH = "src/test/resources/";
    private static final String OUTPUT_FILE_PATH = "src/test/resources/output.txt";

    private static final String MAX_IS_NOT_ISOSCELES = INPUT_PATH + "max_is_not_isosceles.txt";
    private static final String TWO_LONG_ONE_SHORT = INPUT_PATH + "2_long_1_short.txt";
    private static final String ONE_LONG_TWO_SHORT = INPUT_PATH + "1_long_2_short.txt";
    private static final String SKIP_WRONG_LINES = INPUT_PATH + "skip_wrong_lines.txt";
    private static final String MAX_INT = INPUT_PATH + "max_int.txt";

    /**
     * Тест на корректую обработку наибольшего треугольника, который не является равнобедренным.
     *
     * @throws IOException ошибка чтения из выходного файла
     */
    @Test
    public void mainMaxIsNotIsosceles() throws IOException {
        checkMain(MAX_IS_NOT_ISOSCELES, "0 0 1 4 2 0 ");
    }

    /**
     * Тест на корректую обработку наибольшего равнобедренного треугольника, боковые стороны которого больше основания.
     *
     * @throws IOException ошибка чтения из выходного файла
     */
    @Test
    public void main2Long1Short() throws IOException {
        checkMain(TWO_LONG_ONE_SHORT, "0 0 2 4 4 0 ");
    }

    /**
     * Тест на корректую обработку наибольшего равнобедренного треугольника, боковые стороны которого меньше основания.
     *
     * @throws IOException ошибка чтения из выходного файла
     */
    @Test
    public void main1Long2Short() throws IOException {
        checkMain(ONE_LONG_TWO_SHORT, "-4 0 0 4 4 0 ");
    }

    /**
     * Тест на корректую обработку треугольника со сторонами равными наибольшему значению int.
     *
     * @throws IOException ошибка чтения из выходного файла
     */
    @Test
    public void mainMaxInt() throws IOException {
        checkMain(MAX_INT, "2147483647 0 0 0 0 2147483647 ");
    }

    /**
     * Тест на пропуск неккоректных строк с координатами:
     * <li>координаты не являются вершинами треугольника</li>
     * <li>координаты не являются числами</li>
     * <li>число координат меньше 6</li>
     * <li>пустая строка</li>
     * <li>буква после 6-ой координаты</li>
     * <li>набор букв между координатами</li>
     *
     * @throws IOException ошибка чтения из выходного файла
     */
    @Test
    public void mainSkipWrongLines() throws IOException {
        checkMain(SKIP_WRONG_LINES, "-1 -1 10 -1 -1 10 ");
    }

    /**
     * Сквозной тест на метод main. При подаче входного файла осуществляется проверка корректного результата на выходе.
     *
     * @param inputFilePath  путь файла с входными данными
     * @param expectedOutput ожидаемый вывод
     * @throws IOException ошибка чтения из выходного файла
     */
    private void checkMain(String inputFilePath, String expectedOutput) throws IOException {
        setUpOutputFile();
        Application.main(new String[]{inputFilePath, OUTPUT_FILE_PATH});

        File outputFile = new File(OUTPUT_FILE_PATH);
        assertEquals(expectedOutput, readingLine(outputFile));
    }

    /**
     * Чтение строки из выходного файла.
     *
     * @param outputFile выходной файл
     * @return пеервая строка файла
     * @throws IOException ошибка чтения из файла
     */
    private String readingLine(File outputFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(outputFile));
        return bufferedReader.readLine();
    }

    /**
     * Инициализируем выходной файл перед запуском теста.
     *
     * @throws FileNotFoundException ошибка при несуществующем файле
     */
    private void setUpOutputFile() throws FileNotFoundException {
        File outputFile = new File(ApplicationTest.OUTPUT_FILE_PATH);

        //создадим файл, если не существует
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //очистим файл, если уже создан
        PrintWriter printWriter = new PrintWriter(ApplicationTest.OUTPUT_FILE_PATH);
        printWriter.close();
    }
}
