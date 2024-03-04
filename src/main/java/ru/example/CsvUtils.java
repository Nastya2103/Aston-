package ru.example;

import java.io.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvUtils {
    public static void save(AppData data, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            StringBuilder headerLine = new StringBuilder();
            for (String headerValue : data.getHeader()) {
                headerLine.append(headerValue).append(";");
            }
            writer.write(headerLine.toString());
            writer.newLine();
            for (int[] row : data.getData()) {
                StringBuilder dataLine = new StringBuilder();
                for (int value : row) {
                    dataLine.append(value).append(";");
                }
                writer.write(dataLine.toString());
                writer.newLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static AppData load(AppData data, File file) {
        /*String[] headers = {"Value1", "Value2", "Value3"};
        int[][] dataTable = {{100, 200, 123}, {300, 400, 500}};
        AppData data = new AppData(headers, dataTable);*/
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String headerLine = reader.readLine();
            String[] headerValues = headerLine.split(";");
            data.setHeader(headerValues);
            String dataLine;
            int rowIndex = 0;
            while ((dataLine = reader.readLine()) != null) {
                String[] dataValues = dataLine.split(";");
                int[] row = new int[dataValues.length];
                for (int i = 0; i < dataValues.length; i++) {
                    row[i] = Integer.parseInt(dataValues[i]);
                }
                data.getData()[rowIndex] = row;
                rowIndex++;
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return data;
    }
}
