package racing.domain;

import racing.generator.NumberGenerator;

public class Car {
    private static final int THRESHOLD = 3;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;
    private final NumberGenerator numberGenerator;
    private int position;

    public Car(String carName, NumberGenerator numberGenerator) {
        validateCarName(carName);
        this.carName = carName;
        this.numberGenerator = numberGenerator;
        this.position = 0;
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException();
        }
    }

    public int proceed() {
        int number = numberGenerator.generate();
        if (this.canGo(number)) {
            this.position++;
        }

        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    private boolean canGo(int number) {
        return (number > THRESHOLD);
    }
}
