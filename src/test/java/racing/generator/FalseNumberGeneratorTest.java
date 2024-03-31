package racing.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FalseNumberGeneratorTest {
    @DisplayName("FalseNumberGenerator 의 정상 작동 테스트 (0~3 사이의 수를 생성)")
    @Test
    void falseNumber() {
        NumberGenerator numberGenerator = new FalseNumberGenerator();
        assertThat(numberGenerator.generate()).isEqualTo(0);
    }
}
