package pricing;

public class EarlyBirdPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.80; // 20% скидка
    }
}