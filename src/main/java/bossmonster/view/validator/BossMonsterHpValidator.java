package bossmonster.view.validator;

import bossmonster.util.StringConvertor;

public class BossMonsterHpValidator {
    private static final int MIN_MONSTER_HP_RANGE = 100;
    private static final int MAX_MONSTER_HP_RANGE = 300;

    private BossMonsterHpValidator() {
    }

    public static void validate(String input) {
        validateIsNumber(input);
        validateBlank(input);
        validateHpRange(input);
    }

    private static void validateIsNumber(String input) {
        if (!RegexPattern.ONLY_NUMBER.matches(input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    private static void validateHpRange(String input) {
        int hp = StringConvertor.convertToInt(input);
        if (hp < MIN_MONSTER_HP_RANGE || hp > MAX_MONSTER_HP_RANGE) {
            throw new IllegalArgumentException("보스 몬스터의 HP는 100이상 300이하여야합니다.");
        }
    }
}
