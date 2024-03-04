package ru.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] headers = {"Value1", "Value2", "Value3"};
        int[][] dataTable = new int[2][3];
        dataTable[0][1] = 200;
        dataTable[0][0] = 100;
        dataTable[0][2] = 123;
        dataTable[1][0] = 300;
        dataTable[1][1] = 400;
        dataTable[1][2] = 500;

        File file = new File("demo.csv");
        AppData data = new AppData(headers, dataTable);

        CsvUtils.save(data, file);
        CsvUtils.load(data, file);
    }
}