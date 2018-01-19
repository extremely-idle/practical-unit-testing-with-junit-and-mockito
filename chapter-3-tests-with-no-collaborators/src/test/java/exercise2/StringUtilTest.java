package exercise2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class StringUtilTest {

    public Object[] stringInputs() {
        return new Object[] {
                new Object[] {"abcdef", "fedcba"},
                new Object[] {"", ""}
        };
    }

    @Test
    @Parameters(method = "stringInputs")
    public void test(String string, String expected) {
        String actual = StringUtil.reverse(string);

        Assert.assertEquals("String should be reversed", expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowNullPointerException_When_NullUsedAsInput() {
        StringUtil.reverse(null);
    }
}