package exercises.exercise2;

import java.util.ArrayList;
import java.util.List;

public class RegexValidator {

    public static final String REGEX = ".*\\d{3}.*";
    public static final String NUMERIC_REGEX = "\\d";
    public static final int MATCHING_NUMBER_OF_SEQUENTIAL_NUMBERS = 3;
    public static final String CATCHALL_REGEX = "";

    public String[] validate(String string) {
        if (!string.matches(REGEX)) {
            return new String[0];
        }

        List<String> result = isStringValid(string);

        return toStringArray(result);
    }

    private List<String> isStringValid(String string) {
        List<String> result = new ArrayList<>();
        String[] constituentStringArray = string.split(CATCHALL_REGEX);
        for (int i = 0; i < (constituentStringArray.length - 1); i++) {
            String s = constituentStringArray[i];
            if (isNumeric(s) && isConsecutiveNumbers(string, Math.min((i + 1), (constituentStringArray.length - 1)),
                    Math.min((i + 2), (constituentStringArray.length - 1)))) {
                String consecutiveNumbersString = retrieveConsecutiveNumbers(constituentStringArray, i);
                result.add(consecutiveNumbersString);
                i+=2;
            }
        }
        return result;
    }

    private String retrieveConsecutiveNumbers(String[] constituentStringArray, int startIndex) {
        StringBuilder builder = new StringBuilder(constituentStringArray[startIndex]);
        for (int i = (startIndex + 1); i <= (startIndex) + 2; i++) {
            builder.append(constituentStringArray[i]);
        }

        return builder.toString();
    }

    private boolean isConsecutiveNumbers(String string, int startIndex, int endIndex) {
        boolean hasConsecutiveNumbers = false;
        String[] substringArray = string.substring(startIndex, endIndex + 1).split(CATCHALL_REGEX);
        int count = 1;
        for (String substring : substringArray) {
            if (isNumeric(substring)) {
                count++;
                if (count == MATCHING_NUMBER_OF_SEQUENTIAL_NUMBERS) {
                    hasConsecutiveNumbers = true;
                    break;
                }
            } else {
                break;
            }
        }

        return hasConsecutiveNumbers;
    }

    private boolean isNumeric(String s) {
        return s.matches(NUMERIC_REGEX);
    }

    private String[] toStringArray(List<String> result) {
        String[] stringResult = new String[result.size()];
        return result.toArray(stringResult);
    }
}