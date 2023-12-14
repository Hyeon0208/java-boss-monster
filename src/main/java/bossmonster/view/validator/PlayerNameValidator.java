package bossmonster.view.validator;

public class PlayerNameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    private PlayerNameValidator() {
    }

    public static void validate(String input) {
        validatePlayerNameLength(input);
        validateBlank(input);
    }

    private static void validatePlayerNameLength(String input) {
        if (input.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
