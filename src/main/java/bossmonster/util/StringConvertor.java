package bossmonster.util;

import java.util.Arrays;

public class StringConvertor {

    private StringConvertor() {
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }

    public static int[] convertStringArrayToIntArray(String[] values) {
        return Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
