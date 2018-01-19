package exercise4;

public class FahrenheitCelciusConverter {
    public static int toCelcius(int fahrenheit) {
        return (int) Math.round((fahrenheit - 32) * (5.0 / 9.0));
    }

    public static int toFahrenheit(int celcius) {
        return (int) Math.round((celcius * (9.0 / 5.0)) + 32);
    }
}