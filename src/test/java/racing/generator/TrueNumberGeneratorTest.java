package racing.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrueNumberGeneratorTest {
    @DisplayName("TrueNumberGenerator 의 정상 작동 테스트 (4~9 사이의 수를 생성)")
    @Test
    void trueNumber() {
        NumberGenerator numberGenerator = new TrueNumberGenerator();
        assertThat(numberGenerator.generate()).isEqualTo(9);
    }
}
