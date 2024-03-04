package org.example;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Петрова Екатерина Олеговна", "Администратор", "jdh@jhhf", 89997859635L, 25000, 20);
        Employee employee2 = new Employee("Иванова Ирина Антоновна", "Менеджер", "jj@hjhfj", 89991115588L, 58545, 30);
        Employee employee3 = new Employee("Сидоров Максим Петровна", "Начальник отдела", "jdhj@fhgjh", 899952555787L, 75525, 90);

        employee1.printInfo();
        employee2.printInfo();
        employee3.printInfo();

        System.out.println("***********************************************************");

        Person[] persArray = new Employee[5];
        persArray[0] = new Employee("Иванов Иван", "Инженер", "ivan@mail.ru", 89524555428L, 30000, 30);
        persArray[1] = new Employee("Владимирова Диана", "Строитель", "mkfjjfj@yandex.ru", 8925222533322L, 50000, 40);
        persArray[2] = new Employee("Прохоров Петр", "Каскадер", "jhjdhvjhv@gmail.com", 895452235521L, 80000, 35);
        persArray[3] = new Employee("Андреев Владимир", "Программист", "jdhfjhfh@jjdhdfh", 8952255225223L, 100000, 37);
        persArray[4] = new Employee("Емельянов Алексей", "Ведущий менеджер", "vkkdjfjj@cjdvh", 89225522265L, 96924, 50);
        for (Person person : persArray)
            person.printInfo();

        System.out.println("************************************************************");

        Park park = new Park("Южный");
        Park.Attractions attraction1 = park.new Attractions("Колесо обозрения", "9:00-23:00", 250);
        Park.Attractions attraction2 = park.new Attractions("Американские горки", "10:00-20:00", 400);
        Park.Attractions attraction3 = park.new Attractions("Карусель", "9:30-21:00", 350.50);
        Park.Attractions attraction4 = park.new Attractions("Комната страха", "10:00-23:00", 333.33);

        System.out.println(attraction1.getName());
        System.out.println(attraction2.getTimetable());
        System.out.println(attraction3.getPrice());
        attraction4.setTimetable("11:00-24:00");
        System.out.println(attraction4.getTimetable());
        park.setDesignation("Северный");
        System.out.println(park.getDesignation());
    }
}
