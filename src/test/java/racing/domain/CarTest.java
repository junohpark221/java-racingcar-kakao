package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.generator.FalseNumberGenerator;
import racing.generator.TrueNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("4~9까지의 숫자가 나올 경우 전진함을 확인하는 테스트")
    @Test
    void go() {
        Car car = new Car("car_name", new TrueNumberGenerator());

        car.proceed();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("0~3 사이의 숫자가 나올 경우 전진하지 않음을 확인하는 테스트")
    @Test
    void stop() {
        Car car = new Car("car_name", new FalseNumberGenerator());

        car.proceed();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
