import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;
    private float weight;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
        weight += fruitWeight(fruit);
    }

    private float fruitWeight(T fruit) {
        if (fruit instanceof Apple) {
            return 1.0F;
        }
        if (fruit instanceof Orange) {
            return 1.5F;
        } else {
            return 0.0F;
        }
    }

    public float getBoxWeight() {
        return weight;
    }

    public boolean compare(Box<?> box) {
        return Float.compare(this.getBoxWeight(), box.getBoxWeight()) == 0;
    }

    public void toEmpty(Box<T> box) {
        for (T fruit : fruits) {
            box.add(fruit);
        }
        fruits.clear();
        weight = 0;
        System.out.println("Фрукты из одной коробки пересыпали в другую.");
    }
}
