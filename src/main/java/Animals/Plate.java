package Animals;

public class Plate {
    protected int food;

    public Plate(int food) {
        this.food = food;
    }


    public void decreaseFood(int p) {
        food -= p;
    }

    public void increaseFood(int x) {
        food += x;
    }

    public void plateInfo() {
        System.out.println("В миске " + food + " " + "гр. корма");
    }
}
