package racing.controller;

import racing.domain.Car;
import racing.domain.CarList;
import racing.generator.RandomNumberGenerator;
import racing.view.CarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarController {
    private List<Map<String, Integer>> gameLogs;
    private CarList carList;
    private int turn;

    public CarController(String carNames, int turn) {
        this.gameLogs = new ArrayList<>();
        this.carList = new CarList(carNames);
        this.turn = turn;
    }

    public void run() {
        for (int i = 0; i < turn; i++) {
            gameLogs.add(this.carList.proceed());
        }
    }

    public List<Map<String, Integer>> getGameLogs() {
        return this.gameLogs;
    }

    public CarList getCarList() {
        return this.carList;
    }
}
