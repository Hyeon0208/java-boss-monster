package bossmonster.view.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerStatusValidatorTest {

    @DisplayName("쉼표를 포함하지 않고 입력할 경우 예외각 발생한다.")
    @Test
    void validateContainsComma() {
        String input = "100-100";

        assertThatThrownBy(() -> PlayerStatusValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값을 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateBlank(String input) {
        assertThatThrownBy(() -> PlayerStatusValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값을 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"백,100", "150,오십"})
    void validateIsNumber(String input) {
        assertThatThrownBy(() -> PlayerStatusValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 값이 2개를 초과하면 예외가 발생한다.")
    @Test
    void validateStatusLength() {
        String input = "100,50,50";

        assertThatThrownBy(() -> PlayerStatusValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("HP, MP의 총합이 200이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"100,110", "50,100"})
    void validateTotalSum(String input) {
        assertThatThrownBy(() -> PlayerStatusValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}