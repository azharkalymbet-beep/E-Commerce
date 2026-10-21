package pricing;

public class PricingSelector {
    public static PricingStrategy selectStrategy(int daysBeforeConcert, boolean isHighDemand, WeatherProvider weather) {
        if (daysBeforeConcert > 30) {
            return new EarlyBirdPricingStrategy();
        } else if (isHighDemand) {
            return new SurgeDemandPricingStrategy(weather);
        } else {
            return new StandardPricingStrategy();
        }
    }
}