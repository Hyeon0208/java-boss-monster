package bossmonster.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringConvertorTest {

    @DisplayName("문자열을 정수로 반환한다.")
    @ParameterizedTest
    @CsvSource({"1, 1", "100, 100"})
    void convertToInt(String value, int number) {
        int converted = StringConvertor.convertToInt(value);

        assertThat(converted).isEqualTo(number);
    }

    @DisplayName("문자열 배열을 정수 배열로 반환한다.")
    @Test
    void convertStringArrayToIntArray() {
        String[] values = new String[]{"40", "160"};
        int[] numbers = StringConvertor.convertStringArrayToIntArray(values);
        assertThat(numbers).containsExactly(40, 160);
    }
}