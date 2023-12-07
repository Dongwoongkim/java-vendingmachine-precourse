package vendingmachine.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    private static final String ITEMS_DELIMITER = ";";
    private static final String INFO_DELIMITER = ",";

    private StringUtil() {
    }

    public static Integer convertStringToInteger(String input) {
        return Integer.valueOf(input);
    }

    public static List<String> convertStringToListByItemsDelimiter(String input) {
        return Arrays.stream(input.split(ITEMS_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> convertStringToListByInfoDelimiter(String input) {
        return Arrays.stream(removeBracket(input).split(INFO_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static String removeBracket(String input) {
        return input.substring(1, input.length() - 1);
    }
}
