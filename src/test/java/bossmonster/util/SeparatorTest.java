package bossmonster.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorTest {

    @DisplayName("문자열을 쉼표로 분리하여 배열을 반환한다.")
    @Test
    void splitByComma() {
        String value = "100,100";

        String[] values = Separator.COMMA.split(value);

        assertThat(values).containsExactly("100", "100");
    }
}