package org.example;

public class Employee extends Person {

    public Employee(String name, String post, String email, long phone, int salary, int age) {
        super(name, post, email, phone, salary, age);
    }

    public void printInfo() {
        System.out.println(String.format("Сотрудник - %s (должность - %s, возраст - %s лет). %nДанные сотрудника: телефон - %s, e-mail - %s, зарплата - %s руб.%n", name, post, age, phone, email, salary));
    }
}
