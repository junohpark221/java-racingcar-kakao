package racing.controller;

import racing.domain.Car;
import racing.domain.CarList;
import racing.generator.RandomNumberGenerator;
import racing.view.CarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarController {
    private final CarView carView;
    private List<Map<String, Integer>> gameLogs;

    public CarController() {
        carView = new CarView();
        gameLogs = new ArrayList<>();
    }

    public void run() {
        String carNames = carView.getCarNames();
        CarList carList = new CarList(carNames);

        int turn = carView.getTryCount();

        for (int i = 0; i < turn; i++) {
            gameLogs.add(carList.proceed());
        }

        carView.printGameLogs(gameLogs);
        carView.printWinner(carList);
    }
}
