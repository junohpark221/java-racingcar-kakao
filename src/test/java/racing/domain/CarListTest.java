package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("CarList에 속해있는 개별 Car들의 정상 proceed 여부를 확인하는 테스트")
    @Test
    void multipleCarProceed() {
        carList.proceed();

        assertThat(carList.findByName("car1").getPosition()).isEqualTo(1);
        assertThat(carList.findByName("car2").getPosition()).isEqualTo(0);
    }

    @DisplayName("CarList에 속해있는 Car의 이름 존재 확인 테스트")
    @Test
    void existCarName() {
        assertThat(carList.findByName("car1")).isNotNull();
    }

    @DisplayName("CarList에 속해있는 Car의 이름 미존재 확인 테스트")
    @Test
    void notExistCarName() {
        assertThat(carList.findByName("no_name")).isNull();
    }

    @DisplayName("게임 종료 후 우승자 확인 테스트")
    @Test
    void getWinner() {
        carList.proceed();

        List<Car> winner = carList.getWinner();

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getCarName()).isEqualTo("car1");
    }
}
