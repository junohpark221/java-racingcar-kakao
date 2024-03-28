package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Delimiter delimiter;
    Validator validator;

    @BeforeEach
    void setUp() {
        this.delimiter = new Delimiter();
        this.validator = new Validator();
    }

    @Test
    void validateSuccess() {
        String expression = "1,2;3";

        validator.validate(expression, delimiter);
    }

    @Test
    void validateFailWithInvalidDelimiter() {
        String expression = "1?2;3";
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            validator.validate(expression, delimiter);
        });
    }

    @Test
    void validateCustomDelimiter() {
        String expression = "//?\\n1,2;3?4";
        expression = delimiter.customizeExpression(expression);
        validator.validate(expression, delimiter);
    }
}
