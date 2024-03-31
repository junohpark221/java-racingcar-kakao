package racing.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameValidatorTest {
    CarNameValidator validator;
    @BeforeEach
    void setUp() {
        validator = new CarNameValidator();
    }

    @DisplayName("조건을 만족하는 이름의 통과 테스트")
    @Test
    void carNameValidateSuccess() {
        String carNames = "abc,def,ghi";

        assertThat(validator.validate(carNames));
    }

    @DisplayName("이름 길이가 5를 초과하는 경우 실패 테스틑")
    @Test
    void carNameValidateFail() {
        String carNames = "abcdef,advegdd";

        assertThat(validator.validate(carNames)).isFalse();
    }
}
