package Geometry;

public class Rectangle implements Figure, BackgroundFill, BorderColoring {
    private double width;
    private double height;
    private String colorBackground;
    private String colorBorders;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double checkPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double checkArea() {
        return width * height;
    }

    @Override
    public void defineColorBackground(String color) {
        this.colorBackground = color;
    }

    @Override
    public void defineColorBorders(String color) {
        this.colorBorders = color;
    }

    @Override
    public String toString() {
        return "Прямоугольник: " + "Периметр = " + checkPerimeter() + ". Площадь = " + checkArea() + ". Цвет фона - " + colorBackground + ". Цвет границ - " + colorBorders + ".";
    }
}
