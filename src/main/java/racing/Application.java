package racing;

import racing.controller.CarController;
import racing.view.CarOutputView;
import racing.view.CarInputView;

public class Application {
    public static void main(String[] args) {
        CarInputView carView = new CarInputView();
        String carNames = carView.getCarNames();
        int turn = carView.getTryCount();

        CarController carController = new CarController(carNames, turn);
        carController.run();

        CarOutputView.printGameLogs(carController.getGameLogs());
        CarOutputView.printWinner(carController.getCarList());
    }
}
