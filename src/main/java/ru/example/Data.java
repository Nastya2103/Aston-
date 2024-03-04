package ru.example;

public class Data {
   /* Пример массива с ошибкой в ячейке = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "#", "4", "4"}};
    Пример массива с ошибкой в размере = {{"1", "1", "1", "1"}, {"2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
    Пример корректного массива = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};*/

    static int sizeA = 4;
    static int sizeB = 4;

    public static void main(String[] args) {

        String[][] array = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "#", "4", "4"}};
        try {
            try {
                int result = getControlAndSumm(array);
                System.out.println(result);
            } catch (MyArraySizeExсeption e) {
                System.out.println("Ошибка в размере массива");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива. Неверные данные находятся в следующей ячейке: [" + e.i + "]" + "[" + e.j + "]");
        }
    }

        static Integer getControlAndSumm(String[][]array) throws MyArraySizeExсeption, MyArrayDataException {
            Integer summ = 0;
            if (array.length != sizeA) {
                throw new MyArraySizeExсeption();
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != sizeB) {
                    throw new MyArraySizeExсeption();
                }
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        summ = summ + Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            System.out.println("Массив корректный. Результат суммы данных:");
            return summ;
        }
    }

