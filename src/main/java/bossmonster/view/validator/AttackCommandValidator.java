package bossmonster.view.validator;

import bossmonster.constant.GameValue;

public class AttackCommandValidator {

    private AttackCommandValidator() {
    }

    public static void validate(String input) {
        validateBlank(input);
        validateAttackCommand(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    private static void validateAttackCommand(String input) {
        if (!input.equals(GameValue.PHYSICAL_ATTACK) && !input.equals(GameValue.MAGIC_ATTACK)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }
}
