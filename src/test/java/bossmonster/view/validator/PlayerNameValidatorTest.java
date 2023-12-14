package bossmonster.view.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameValidatorTest {

    @DisplayName("5글자가 넘어가는 이름을 입력시 예외가 발생한다.")
    @Test
    void validatePlayerNameLength() {
        String input = "도비도비도비";

        assertThatThrownBy(() -> PlayerNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 값을 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateBlank(String input) {
        assertThatThrownBy(() -> PlayerNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}