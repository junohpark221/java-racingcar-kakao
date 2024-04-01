package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.validator.CarNameValidator;
import racing.validator.TryCountValidator;
import racing.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarView {
    private final Scanner scanner;
    private final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String GET_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String NAME_ERROR_MESSAGE = "[Error] 잘못된 이름 형식입니다. 다시 입력해주세요.";
    private final String COUNT_ERROR_MESSAGE = "[Error] 잘못된 횟수 입니다. 다시 입력해주세요.";

    public CarView() {
        scanner = new Scanner(System.in);
    }

    private void printResultDescription() {
        System.out.println("\n실행결과");
    }

    public void printGameLogs(List<Map<String, Integer>> gameLogs) {
        printResultDescription();
        for (Map<String, Integer> gameLog : gameLogs) {
            printGameLog(gameLog);
        }
    }

    private void printGameLog(Map<String, Integer> gameLog) {
        for (Map.Entry<String, Integer> log : gameLog.entrySet()) {
            printCar(log);
        }
        System.out.println();
    }

    private void printCar(Map.Entry<String, Integer> log) {
        StringBuilder status = new StringBuilder(log.getKey() + " : ");
        status.append("-".repeat(log.getValue()));

        System.out.println(status);
    }

    public void printWinner(Cars carList) {
        List<Car> winners = carList.getWinner();
        List<String> winnerNameList = new ArrayList<>();
        for (Car winner : winners) {
            winnerNameList.add(winner.getCarName());
        }
        System.out.println(String.join(", ", winnerNameList) + "가 최종 우승 했습니다.");
    }

    public String getCarNames() {
        CarNameValidator carNameValidator = new CarNameValidator();
        return getUserInput(carNameValidator, GET_CAR_NAME_MESSAGE, NAME_ERROR_MESSAGE);
    }

    public Integer getTryCount() {
        TryCountValidator tryCountValidator = new TryCountValidator();
        String userInput = getUserInput(tryCountValidator, GET_COUNT_MESSAGE, COUNT_ERROR_MESSAGE);

        return Integer.parseInt(userInput);
    }

    private String getUserInput(Validator validator, String message, String errorMessage) {
        boolean validated;
        String input;

        do {
            System.out.println(message);
            input = scanner.nextLine();
            validated = validator.validate(input);
            printError(validated, errorMessage);
        } while(!validated);

        return input;
    }

    private void printError(boolean validated, String errorMessage) {
        if (!validated) {
            System.out.println(errorMessage);
        }
    }
}
