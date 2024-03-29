package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.generator.FalseNumberGenerator;
import racing.generator.TrueNumberGenerator;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    CarList carList;

    @BeforeEach
    void setUp() {
        TrueNumberGenerator trueNumberGenerator = new TrueNumberGenerator();
        FalseNumberGenerator falseNumberGenerator = new FalseNumberGenerator();
        this.carList = new CarList(
                Arrays.asList(
                        new Car("car1", trueNumberGenerator),
                        new Car("car2", falseNumberGenerator)
                )
        );
    }

    @Test
    void multipleCarProceed() {
        carList.proceed();

        assertThat(carList.findByName("car1").getPosition()).isEqualTo(1);
        assertThat(carList.findByName("car2").getPosition()).isEqualTo(0);
    }

    @Test
    void existCarName() {
        assertThat(carList.findByName("car1")).isNotNull();
    }

    @Test
    void notExistCarName() {
        assertThat(carList.findByName("no_name")).isNull();
    }

    @Test
    void getWinner() {
        carList.proceed();

        List<Car> winner = carList.getWinner();

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getCarName()).isEqualTo("car1");
    }
}
