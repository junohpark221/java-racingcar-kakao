package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarOutputView {
    private static void printResultDescription() {
        System.out.println("\n실행결과");
    }

    public static void printGameLogs(List<Map<String, Integer>> gameLogs) {
        printResultDescription();
        for (Map<String, Integer> gameLog : gameLogs) {
            printGameLog(gameLog);
        }
    }

    private static void printGameLog(Map<String, Integer> gameLog) {
        for (Map.Entry<String, Integer> log : gameLog.entrySet()) {
            printCar(log);
        }
        System.out.println();
    }

    private static void printCar(Map.Entry<String, Integer> log) {
        StringBuilder status = new StringBuilder(log.getKey() + " : ");
        status.append("-".repeat(log.getValue()));

        System.out.println(status);
    }

    public static void printWinner(List<Car> winners) {
        List<String> winnerNameList = new ArrayList<>();
        for (Car winner : winners) {
            winnerNameList.add(winner.getCarName());
        }
        System.out.println(String.join(", ", winnerNameList) + "가 최종 우승 했습니다.");
    }
}
