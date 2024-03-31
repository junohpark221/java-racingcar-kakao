package racing.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountValidatorTest {
    TryCountValidator validator;
    @BeforeEach
    void setUp() {
        validator = new TryCountValidator();
    }

    @DisplayName("정상적인 게임 진행 턴 수의 validation 통과 테스트")
    @Test
    void tryCountSuccessTest() {
        Assertions.assertThat(validator.validate("123")).isTrue();
    }

    @DisplayName("정상적이지 못한 게임 진행 턴 수의 validation 통과 실패 테스트")
    @Test
    void tryCountFailTest() {
        Assertions.assertThat(validator.validate("1a3")).isFalse();
    }
}
