package model;

public class Car {
    private final String name;

    private final int velocity;

    public Car(String name, int velocity) {
        this.name = name;
        this.velocity = velocity;
    }

    public String getName() {
        return name;
    }

    public int getVelocity() {
        return velocity;
    }
}
