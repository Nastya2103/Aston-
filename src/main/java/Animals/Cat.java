package Animals;

public class Cat extends Animal {
    private final int distanceRun;
    private final int distanceSwim;
    protected int appetite;
    protected boolean fullness;
    private static int catCount = 0;

    public Cat(String name, int metersOfRun, int metersOfSwim, int appetite) {
        super(name, metersOfRun, metersOfSwim);
        this.distanceRun = 200;
        this.distanceSwim = 0;
        this.appetite = appetite;
        this.fullness = false;

        catCount++;
    }

    public int getAppetite() {
        return appetite;
    }

    public static int getCatCount() {
        return catCount;
    }

    public int run() {
        if (metersOfRun >= distanceRun) {
            System.out.printf("%s пробежал %s м.%n", name, metersOfRun);
        }
        if (metersOfRun < distanceRun) {
            System.out.printf("%s пробежал %s м. (не добежал %s м.)%n", name, metersOfRun, (distanceRun - metersOfRun));
        }
        return distanceRun;
    }

    public int swim() {
        if (metersOfSwim > distanceSwim) {
            System.out.printf("%s потрогал лапкой воду, свалился в воду, потом фыркнул и ушел%n", name, metersOfSwim);
        }
        if (metersOfSwim <= distanceSwim) {
            System.out.printf("%s не умеет плавать%n", name, (distanceSwim - metersOfSwim));
        }
        return distanceSwim;
    }

    @Override
    public void printInfo() {
        System.out.printf("%s должен пробежать %s м. и проплыть %s м.%n", name, distanceRun, distanceSwim);
        run();
        swim();
    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
    }
}
