package pricing;

public class SimulatedWeatherProvider implements WeatherProvider {
    private final boolean badWeather;

    public SimulatedWeatherProvider(boolean badWeather) {
        this.badWeather = badWeather;
    }

    @Override
    public boolean isBadWeather() {
        return badWeather;
    }
}