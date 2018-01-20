package exercises.exercise1;

public class PasswordValidator {

    public static final int MINIMUM_PASSWORD_LENGTH = 8;
    public static final String MINIMUM_NUMBER_OF_DIGITS_REGEX = "\\w*[_+!?@~#=$£%*()]*\\d{4}?\\w*[_+!?@~#=$£%*()]*";
    public static final String MINIMUM_NUMBER_OF_SPECIAL_CHARACTERS_REGEX = "\\w*[_+!?@~#=$£%*()]+\\w*";
    public static final String SINGLE_DIGIT_MIXED_WITHIN_PASSWORD_REGEX = "(.)*\\d+(.)*\\d+(.)*\\d+(.)*\\d+(.)*";
    public static final String TWO_DIGITS_MIXED_WITHIN_PASSWORD_REGEX = "(.)*\\d{2}(.)*\\d{2}(.)*";

    public boolean validate(String password) {
        return password.length() >= MINIMUM_PASSWORD_LENGTH && doesPasswordMeetNumericCriteria(password) &&
                        password.matches(MINIMUM_NUMBER_OF_SPECIAL_CHARACTERS_REGEX);
    }

    private boolean doesPasswordMeetNumericCriteria(String password) {
        return password.matches(MINIMUM_NUMBER_OF_DIGITS_REGEX) ||
               password.matches(SINGLE_DIGIT_MIXED_WITHIN_PASSWORD_REGEX) ||
               password.matches(TWO_DIGITS_MIXED_WITHIN_PASSWORD_REGEX);
    }
}