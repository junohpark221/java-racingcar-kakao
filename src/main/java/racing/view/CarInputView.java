package racing.view;

import racing.validator.CarNameValidator;
import racing.validator.TryCountValidator;
import racing.validator.Validator;

import java.util.Scanner;

public class CarInputView {
    private final Scanner scanner;
    private final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String GET_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final String NAME_ERROR_MESSAGE = "[Error] 잘못된 이름 형식입니다. 다시 입력해주세요.";
    private final String COUNT_ERROR_MESSAGE = "[Error] 잘못된 횟수 입니다. 다시 입력해주세요.";

    public CarInputView() {
        scanner = new Scanner(System.in);
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
