package racing.controller;

import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarController {
    private List<Map<String, Integer>> gameLogs;
    private Cars cars;
    private int turn;

    public CarController(String carNames, int turn) {
        this.gameLogs = new ArrayList<>();
        this.cars = new Cars(carNames);
        this.turn = turn;
    }

    public void run() {
        for (int i = 0; i < turn; i++) {
            gameLogs.add(this.cars.proceed());
        }
    }

    public List<Map<String, Integer>> getGameLogs() {
        return this.gameLogs;
    }

    public Cars getCars() {
        return this.cars;
    }
}
