package exercise4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {

    public Object[] celciusToFahrenheit() {
        return new Object[] {
                new Object[] {0, 32},
                new Object[]{37, 99},
                new Object[] {100, 212}
        };
    }

    public Object[] fahrenheitToCelcius() {
        return new Object[] {
                new Object[] {32, 0},
                new Object[] {100, 38},
                new Object[] {212, 100}
        };
    }

    @Test
    @Parameters(method = "celciusToFahrenheit")
    public void should_ConvertCelciusToFahrenheit(int celcius, int expected) {
        int actual = FahrenheitCelciusConverter.toFahrenheit(celcius);

        assertEquals("should convert " + celcius + " degrees celcius to " + actual +
                " degrees fahrenheit", expected, actual);
    }

    @Test
    @Parameters(method = "fahrenheitToCelcius")
    public void should_ConvertFahrenheitToCelcius(int fahrenheit, int expected) {
        int actual = FahrenheitCelciusConverter.toCelcius(fahrenheit);

        assertEquals("should convert " + fahrenheit + " degrees fahrenheit to " + actual +
                " degrees celcius", expected, actual);
    }
}