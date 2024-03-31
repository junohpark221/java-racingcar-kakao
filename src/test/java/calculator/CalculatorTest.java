package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CalculatorTest {
    @DisplayName("입력된 숫자들을 바탕으로 calculator의 작동 테스트")
    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        List<Integer> numberList = Arrays.asList(1,2,3);

        Assertions.assertThat(calculator.calculate(numberList)).isEqualTo(6);
    }
}
