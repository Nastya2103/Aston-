package ru.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<Long>> phoneBook = new HashMap<>();

    public void add(String surname, Long phoneNumber) {
        List<Long> phoneNumberList;
        if (phoneBook.containsKey(surname)) {
            phoneNumberList = phoneBook.get(surname);
            phoneNumberList.add(phoneNumber);
            phoneBook.put(surname, phoneNumberList);
        } else {
            phoneNumberList = new ArrayList<>();
            phoneNumberList.add(phoneNumber);
            phoneBook.put(surname, phoneNumberList);
        }
    }

    public List<Long> get(String surname) {
        return phoneBook.get(surname);
    }
}
