package exercises.exercise2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class RegexValidatorTest {
    private RegexValidator regexValidator;

    public Object[] regexStrings() {
        return new Object[] {
                new Object[] {"abc 12" , new String[]{}},
                new Object[] {"cdefg 345 12bb23", new String[] {"345"}},
                new Object[] {"cdefg 345 12bb33 678tt", new String[]{"345", "678"}}
        };
    }

    @Before
    public void init() {
        regexValidator = new RegexValidator();
    }

    @Test
    @Parameters(method = "regexStrings")
    public void shouldValidateStringAgainstRegex(String string, String[] expected) {
        // Arrange, Act
        String[] actual = regexValidator.validate(string);

        // Assert
        assertArrayEquals("The \"" + string + "\" should return \"" + expected + "\"", expected, actual);
    }
}