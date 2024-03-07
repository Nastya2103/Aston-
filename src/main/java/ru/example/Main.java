package ru.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] fruits = {"peach", "banana", "apple", "orange", "pear", "apricot", "mandarin", "lemon", "melon", "kiwi", "mango", "pear", "pear", "apple", "mandarin", "mandarin", "mandarin"};

        Set<String> uniqueFruit = new HashSet<>(Arrays.asList(fruits));
        System.out.println(uniqueFruit);

        HashMap<String, Integer> dictFruit = new HashMap<>();
        for (String fruit : fruits) {
            if (!dictFruit.containsKey(fruit)) {
                dictFruit.put(fruit, 1);
            } else {
                int value = dictFruit.get(fruit);
                dictFruit.replace(fruit, ++value);
            }
        }
        System.out.println(dictFruit);

        System.out.println("***************************************************************************************************");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", 89333333333L);
        phoneBook.add("Иванов", 89111111111L);
        phoneBook.add("Сидоров", 89222222222L);
        phoneBook.add("Сидоров", 89222222222L);
        phoneBook.add("Петрова", 89444444444L);
        phoneBook.add("Владимирова", 89455555554L);
        phoneBook.add("Борисова", 89453335554L);
        phoneBook.add("Кузнецова", 89433333554L);
        phoneBook.add("Краснова", 89666655554L);
        phoneBook.add("Краснова", 89777655554L);
        phoneBook.add("Павлова", 89777777554L);
        phoneBook.add("Павлов", 89666666666L);
        phoneBook.add("Павлов", 89666623366L);

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Сидоров"));
        System.out.println(phoneBook.get("Владимирова"));
        System.out.println(phoneBook.get("Павлов"));
    }
}