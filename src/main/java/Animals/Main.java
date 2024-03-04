package Animals;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int action;
        Cat cat1 = new Cat("Пушок", 200, 0, 20);
        Cat cat2 = new Cat("Комок шерсти", 130, 2, 25);
        Cat cat3 = new Cat("Беляш", 95, 5, 30);
        Dog dog1 = new Dog("Рекс", 450, 10);
        Dog dog2 = new Dog("Лекс", 500, 9);
        Dog dog3 = new Dog("Джерри", 600, 12);


        Animal[] animals = {cat1, cat2, cat3, dog1, dog2, dog3};
        for (Animal animal : animals) {
            animal.printInfo();
        }

        System.out.printf("В состязании участвуют %s собаки и %s кошки. Всего %s животных%n", Dog.getDogCount(), Cat.getCatCount(), (Dog.getDogCount() + Cat.getCatCount()));
        System.out.println("*******************************************************************************************************");

        Cat[] cats = {cat1, cat2, cat3};
        System.out.println("У нас 3 голодных кота: " + cats[0].getName() + ", " + cats[1].getName() + ", " + cats[2].getName());
        Plate plate = new Plate(60);
        System.out.println("Наши коты голодны и они подходят к миске.");
        plate.plateInfo();
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].fullness == false && cats[i].appetite < plate.food) {
                cats[i].eat(plate);
                cats[i].fullness = true;
                System.out.println("Кот " + cats[i].name + " " + "поел.");
            } else {
                System.out.println("Кот " + cats[i].name + " " + "не поел");
            }
        }
        plate.plateInfo();
        System.out.println("В миску нужно добавить корм");
        action = sc.nextInt();
        plate.increaseFood(action);
        plate.plateInfo();
    }
}