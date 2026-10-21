package pricing;

public class SurgeDemandPricingStrategy implements PricingStrategy {
    private final WeatherProvider weatherProvider;

    public SurgeDemandPricingStrategy(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @Override
    public double calculatePrice(double basePrice) {
        // Если плохая погода на крытой арене или ажиотаж — наценка 50%, иначе 25%
        return weatherProvider.isBadWeather() ? basePrice * 1.50 : basePrice * 1.25;
    }
}