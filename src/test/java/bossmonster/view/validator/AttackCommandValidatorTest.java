package bossmonster.view.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttackCommandValidatorTest {

    @DisplayName("빈 값을 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void validateBlank(String input) {
        assertThatThrownBy(() -> AttackCommandValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1 또는 2를 입력할 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validateAttackCommandNoException(String input) {
        assertDoesNotThrow(() -> AttackCommandValidator.validate(input));
    }

    @DisplayName("1 또는 2 외의 값을 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4"})
    void validateAttackCommand(String input) {
        assertThatThrownBy(() -> AttackCommandValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}