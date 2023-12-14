package bossmonster.view.validator;

import bossmonster.constant.GameValue;
import bossmonster.util.Separator;
import bossmonster.util.StringConvertor;

public class PlayerStatusValidator {
    private static final int SUM_CONDITION = 200;
    private static final int STATUS_LENGTH = 2;

    private PlayerStatusValidator() {
    }

    public static void validate(String input) {
        validateContainsComma(input);
        validateBlank(input);
        validateIsNumber(input);
        validateStatusLength(input);
        validateTotalSum(input);
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(Separator.COMMA.getSeparator())) {
            throw new IllegalArgumentException("쉼표로 구분하여 입력해야 합니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    private static void validateIsNumber(String input) {
        for (String status : Separator.COMMA.split(input)) {
            if (!RegexPattern.ONLY_NUMBER.matches(status)) {
                throw new IllegalArgumentException("숫자만 입력 가능 합니다.");
            }
        }
    }

    private static void validateStatusLength(String input) {
        String[] status = Separator.COMMA.split(input);
        if (status.length != STATUS_LENGTH) {
            throw new IllegalArgumentException("HP, MP 총 2개를 입력해야 합니다.");
        }
    }

    private static void validateTotalSum(String input) {
        String[] status = Separator.COMMA.split(input);
        int hp = StringConvertor.convertToInt(status[GameValue.HP_INDEX]);
        int mp = StringConvertor.convertToInt(status[GameValue.MP_INDEX]);
        if ((hp + mp) != SUM_CONDITION) {
            throw new IllegalArgumentException("HP와 MP 합은 200 이어야 합니다.");
        }
    }
}
