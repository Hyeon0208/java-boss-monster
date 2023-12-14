package bossmonster.view.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BossMonsterHpValidatorTest {

    @DisplayName("숫자가 아닌 값을 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"일", "one"})
    void validateIsNumber(String input) {
        assertThatThrownBy(() -> BossMonsterHpValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값을 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateBlank(String input) {
        assertThatThrownBy(() -> BossMonsterHpValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("100 ~ 300 범위가 아닌 값을 입력 시 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"99", "301"})
    void validateHpRange(String input) {
        assertThatThrownBy(() -> BossMonsterHpValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}