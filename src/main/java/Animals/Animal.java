package Animals;

public abstract class Animal {
    protected String name;
    protected int metersOfRun;
    protected int metersOfSwim;

    public Animal(String name, int metersOfRun, int metersOfSwim) {
        this.name = name;
        this.metersOfRun = metersOfRun;
        this.metersOfSwim = metersOfSwim;
    }

    public String getName() {
        return name;
    }

    public abstract void printInfo();
}
