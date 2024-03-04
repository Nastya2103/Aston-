package org.example;

public class Person {
    protected String name;
    protected String post;
    protected String email;
    protected long phone;
    protected int salary;
    protected int age;

    public Person(String name, String post, String email, long phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(String.format("Сотрудник - %s (должность - %s, возраст - %s лет). %nДанные сотрудника: телефон - %s, e-mail - %s, зарплата - %s руб.%n", name, post, age, phone, email, salary));
    }
}
