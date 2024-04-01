package racing.controller;

import racing.domain.Cars;
import racing.domain.GameLog;
import racing.domain.GameLogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarController {
    private GameLogs gameLogs;
    private Cars cars;
    private int turn;

    public CarController(String carNames, int turn) {
        this.gameLogs = new GameLogs();
        this.cars = new Cars(carNames);
        this.turn = turn;
    }

    public void run() {
        for (int i = 0; i < turn; i++) {
            gameLogs.addGameLog(this.cars.proceed());
        }
    }

    public List<Map<String, Integer>> getGameLogsData() {
        return this.gameLogs.getGameLogs()
                .stream()
                .map(GameLog::getGameLog)
                .collect(Collectors.toList());
    }

    public Cars getCars() {
        return this.cars;
    }
}
