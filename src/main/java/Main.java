import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import RaceManager.RaceManager;
import model.Car;
import model.RaceResult;

public class Main {
    private final static int CAR_COUNT = 3;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RaceManager raceManager = new RaceManager();


        System.out.println("Давно тебя не было на уличных гонках!");
        System.out.println("Введи параметры тачек");
        System.out.println();

        List<Car> cars = createCars();

        List<RaceResult> results = raceManager.calculateRaceResult(cars);
        printRaceResult(results, raceManager.winner);
    }

    private static List<Car> createCars() {
        int carNumber = 1;
        List<Car> cars = new ArrayList<>(3);

        while (carNumber <= CAR_COUNT) {
            System.out.printf("Какое имя будет у машины номер %d?", carNumber);
            System.out.println();
            String name = scanner.next();

            System.out.println("А скорость?");

            // Думаю пока не надо заморчиваться с тем, что можно ввести не число?
            int velocity = scanner.nextInt();

            if (velocity <= 0) {
                System.out.println("Машина должна ехать вперед, а не назад, попробуй еще раз");
                continue;
            }

            if (velocity > 250) {
                System.out.println("Слишком быстро! Еще раз.");
                continue;
            }

            Car car = new Car(name, velocity);

            cars.add(car);

            if(CAR_COUNT - carNumber != 0){
                System.out.printf("Отлично, осталось сделать машин: %d", CAR_COUNT - carNumber);
                System.out.println();
            } else {
                System.out.println("Погнали!");
            }

            System.out.println();

            carNumber++;
        }

        return cars;
    }

    private static void printRaceResult(List<RaceResult> results, Car winner) {
        System.out.println("Результаты гонки: ");
        System.out.println("=".repeat(100));

        for (int i = 0; i < results.size(); i++) {
            RaceResult currentResult = results.get(i);
            System.out.printf("Место %d. Имя - '%s', проехала - %d км", i + 1
                    , currentResult.gerCar().getName(), currentResult.getDistance());
            System.out.println();
        }

        System.out.println("=".repeat(100));
        System.out.println();
        System.out.println("Победитель - " + winner.getName());
    }
}