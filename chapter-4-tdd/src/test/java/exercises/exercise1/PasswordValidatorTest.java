package exercises.exercise1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    public Object[] passwords() {
        return new Object[] {
                new Object[] {"abc", false},
                new Object[] {"abcdefgh", false},
                new Object[] {"abcd1234", false},
                new Object[] {"abcdef_123", false},
                new Object[] {"AbCd_1234!", true},
                new Object[] {"Ab12Cd_34!", true}
        };
    }

    @Before
    public void init() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    @Parameters(method = "passwords")
    public void shouldValidatePasswordsCorrectly(String password, boolean expected) {
        // Arrange, Act
        boolean isValidPassword = passwordValidator.validate(password);

        // Assert
        assertEquals("Password " + password + " should " + (expected ? "pass" : "fail") + " validation", expected,
                isValidPassword);
    }
}