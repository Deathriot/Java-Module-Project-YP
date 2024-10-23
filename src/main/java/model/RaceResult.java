package model;

// Дополнительный класс, хранящий все данные о гонке, как по мне так будет красивее
public class RaceResult {
    private final Car car;

    private final int distance;

    public RaceResult(Car car, int distance) {
        this.car = car;
        this.distance = distance;
    }

    public Car gerCar() {
        return car;
    }

    public int getDistance() {
        return distance;
    }
}
