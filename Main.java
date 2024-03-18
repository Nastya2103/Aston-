public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());

        Box<Orange> box2 = new Box<>();
        box2.add(new Orange());
        box2.add(new Orange());

        Box<Apple> box3 = new Box<>();
        box3.add(new Apple());

        Box<Orange> box4 = new Box<>();
        box4.add(new Orange());

        System.out.println("В коробке №1 - " + box1.getBoxWeight() + " кг. яблок.");
        System.out.println("В коробке №2 - " + box2.getBoxWeight() + " кг. апельсинов.");
        System.out.println("В коробке №3 - " + box3.getBoxWeight() + " кг. яблок.");
        System.out.println("В коробке №4 - " + box4.getBoxWeight() + " кг. апельсинов.");

        System.out.println(box1.compare(box2));
        System.out.println(box3.compare(box4));

        box1.toEmpty(box3);
        box2.toEmpty(box4);

        System.out.println("После того, как пересыпали:");

        System.out.println("Вес коробки №1 - " + box1.getBoxWeight() + " кг. яблок.");
        System.out.println("Вес коробки №2 - " + box2.getBoxWeight() + " кг. апельсинов.");
        System.out.println("Вес коробки №3 - " + box3.getBoxWeight() + " кг. яблок.");
        System.out.println("Вес коробки №4 - " + box4.getBoxWeight() + " кг. апельсинов.");
    }
}
