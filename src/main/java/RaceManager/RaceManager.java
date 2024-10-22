package RaceManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Car;
import model.RaceResult;

public class RaceManager {
    public Car winner;

    public List<RaceResult> calculateRaceResult(List<Car> cars) {
        cars.sort(Comparator.comparingInt(Car::getVelocity).reversed());

        winner = cars.get(0);

        List<RaceResult> results = new ArrayList<>(3);

        for (Car car : cars) {

            RaceResult raceResult = new RaceResult(car, car.getVelocity() * 24);
            results.add(raceResult);
        }

        return results;
    }
}
