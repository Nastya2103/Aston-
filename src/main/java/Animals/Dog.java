package Animals;

public class Dog extends Animal {

    private final int distanceRun;
    private final int distanceSwim;
    private static int dogCount;

    public Dog(String name, int metersOfRun, int metersOfSwim) {
        super(name, metersOfRun, metersOfSwim);
        this.distanceRun = 500;
        this.distanceSwim = 10;

        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
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
        if (metersOfSwim >= distanceSwim) {
            System.out.printf("%s проплыл %s м.%n", name, metersOfSwim);
        }
        if (metersOfSwim < distanceSwim) {
            System.out.printf("%s проплыл %s м. (не доплыл %s м.)%n", name, metersOfSwim, (distanceSwim - metersOfSwim));
        }
        return distanceSwim;
    }

    @Override
    public void printInfo() {
        System.out.printf("%s должен пробежать %s м. и проплыть %s м.%n", name, distanceRun, distanceSwim);
        run();
        swim();
    }
}
