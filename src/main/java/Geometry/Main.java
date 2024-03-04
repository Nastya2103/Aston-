package Geometry;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        circle1.defineColorBorders("красный");
        circle1.defineColorBackground("синий");

        Rectangle rectangle1 = new Rectangle(7, 5);
        rectangle1.defineColorBorders("желтый");
        rectangle1.defineColorBackground("зеленый");

        Triangle triangle1 = new Triangle(4, 7, 8);
        triangle1.defineColorBorders("голубой");
        triangle1.defineColorBackground("розовый");

        System.out.println(circle1);
        System.out.println(rectangle1);
        System.out.println(triangle1);
    }
}
