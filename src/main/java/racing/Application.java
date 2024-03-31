package racing;

import racing.controller.CarController;
import racing.domain.CarList;
import racing.view.CarView;

public class Application {
    public static void main(String[] args) {
        CarView carView = new CarView();
        String carNames = carView.getCarNames();
        int turn = carView.getTryCount();

        CarController carController = new CarController(carNames, turn);
        carController.run();

        carView.printGameLogs(carController.getGameLogs());
        carView.printWinner(carController.getCarList());
    }
}
