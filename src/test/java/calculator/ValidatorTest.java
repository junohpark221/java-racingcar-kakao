package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Delimiter delimiter;
    Validator validator;

    @BeforeEach
    void setUp() {
        this.delimiter = new Delimiter();
        this.validator = new Validator();
    }

    @DisplayName("기본 delimiter 과 함께 정상적인 입력 값의 validate 통과 테스트")
    @Test
    void validateSuccess() {
        String expression = "1,2;3";

        validator.validate(expression, delimiter);
    }

    @DisplayName("잘못된 delimiter를 포함하는 입력 값의 validate 통과 실패 테스트")
    @Test
    void validateFailWithInvalidDelimiter() {
        String expression = "1?2;3";
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            validator.validate(expression, delimiter);
        });
    }

    @DisplayName("커스텀 delimiter를 포함하는 입력 값의 validate 통과 테스트")
    @Test
    void validateCustomDelimiter() {
        String expression = "//?\\n1,2;3?4";
        expression = delimiter.customizeExpression(expression);
        validator.validate(expression, delimiter);
    }
}
