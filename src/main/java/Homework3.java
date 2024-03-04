public class Homework3 {

    public static void main(String[] args) {
        System.out.println(limitSum(20, 8));
        isPositiveOrNegative(-8);
        System.out.println(comparisonOfNumbers(-25));
        fewWords(4, "Hello!");
        System.out.println(isLeapYear(700));
        sixthExercise();
        seventhExercise();
        eighthExercise();
        ninthExercise();
        additional(tenthExercise(4,5));
    }

    /* Задание 1. Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.*/
    public static boolean limitSum(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    /* Задание 2.  Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
    в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.*/
    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    /* Задание 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное.*/
    public static boolean comparisonOfNumbers(int c) {
        if (c < 0) {
            return true;
        } else {
            return false;
        }
    }

    /* Задание 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
    в консоль указанную строку, указанное количество раз.*/
    public static void fewWords(int i, String txtTo) {
        for (i = 0; i < 3; i++) {
            System.out.println(txtTo);
        }
    }

    /* Задание 5. Написать метод, который определяет, является ли год високосным, и возвращает boolean
     (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при
     этом каждый 400-й – високосный.*/
    public static boolean isLeapYear(int f) {
        return (f % 4 == 0 && f % 100 != 0 || f % 400 == 0);
    }

    /* Задание 6. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     С помощью цикла и условия заменить 0 на 1, 1 на 0.*/
    public static void sixthExercise() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                System.out.print(arr[i]);
            }
            if (arr[i] == 1) {
                arr[i] = 0;
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }

    /* Задание 7. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4
    5 6 7 8 ... 100.*/
    public static void seventhExercise() {
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
            System.out.print(arr2[i] + "|");
        }
        System.out.println();
    }

    /* Задание 8. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    умножить на 2.*/
    public static void eighthExercise() {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                System.out.print(arr3[i] * 2 + "|");
            }
        }
        System.out.println();
    }

    /* Задание 9. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и
    с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе
    сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
    то есть [0][0], [1][1], [2][2], ..., [n][n]; */
    public static void ninthExercise() {
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    arr4[i][j] = 1;
                } System.out.print(arr4[i][j] + " | ");
            } System.out.println();
        }
    }

    /* Задание 10. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный
    массив типа int длиной len, каждая ячейка которого равна initialValue.*/
    public static int[] tenthExercise(int len, int initialValue) {
        int[] arr5 = new int[len];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = initialValue;
        } return arr5;
    }

    public static void additional(int[] len2) {
        for (int i = 0; i < len2.length; i++) {
            System.out.print(len2[i] + "|");
        }
    }
}





