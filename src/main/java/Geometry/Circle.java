package Geometry;

public class Circle implements Figure, BackgroundFill, BorderColoring {
    private double radius;
    private String colorBackground;
    private String colorBorders;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double checkPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public double checkArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void defineColorBorders(String color) {
        this.colorBorders = color;
    }

    @Override
    public void defineColorBackground(String color) {
        this.colorBackground = color;
    }

    @Override
    public String toString() {
        return "Круг: " + "Периметр = " + checkPerimeter() + ". Площадь = " + checkArea() + ". Цвет фона - " + colorBackground + ". Цвет границ - " + colorBorders + ".";
    }
}
