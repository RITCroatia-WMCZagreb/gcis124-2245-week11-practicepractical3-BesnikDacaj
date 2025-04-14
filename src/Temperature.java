import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Temperature {

    public interface TemperatureScale {
        double convert(double temperature);
    }

    /**
     * Part A
     * Create and return an anonymous class of type TemperatureScale that
     * converts a temperature given in Fahrenheit to Celsius
     * C = (F - 32) / 1.8
     */
    public static TemperatureScale createF2C() {
        TemperatureScale f2C = new TemperatureScale() {
            @Override
            public double convert(double temperature) {
                return (temperature - 32) / 1.8;
            }
        };
        return f2C;
    }

    /**
     * Part B
     * Create and return a lambda of type TemperatureScale that
     * converts a temperature given in Celsius to Fahrenheit
     * F = (C * 1.8) + 32
     */
    public static TemperatureScale createC2F() {
        TemperatureScale c2F = (temperature) -> (temperature * 1.8) + 32;
        return c2F;
    }

    public static void main(String[] args) {

        TemperatureScale c2F = createC2F();
        TemperatureScale f2C = createF2C();

        List<Double> temps = Arrays.asList(0.0, 32.0, 12.3, 45.6, -12.0);

        List<Double> celsiusTemps = new ArrayList<>();
        List<Double> fahrenheitTemps = new ArrayList<>();

        // Part C
        for (double temp : temps) {
            fahrenheitTemps.add(c2F.convert(temp));
            celsiusTemps.add(f2C.convert(temp));
        }

        // Part D
        System.out.println("Fahrenheit temps above freezing (32F):");
        fahrenheitTemps.stream()
                .filter(f -> f > 32)
                .forEach(System.out::println);

        // Part E
        System.out.println("Celsius temps below freezing (0C):");
        celsiusTemps.stream()
                .filter(c -> c < 0)
                .forEach(System.out::println);
    }
}
