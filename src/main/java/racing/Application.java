package racing;

import racing.controller.CarController;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.run();
    }
}
