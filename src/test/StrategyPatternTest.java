import pricing.*;
import allocation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyPatternTest {

    // --- Fake Implementation for Testing Isolation ---
    static class FakeWeatherProvider implements WeatherProvider {
        private final boolean badWeather;
        public FakeWeatherProvider(boolean badWeather) { this.badWeather = badWeather; }
        @Override public boolean isBadWeather() { return badWeather; }
    }

    @Test
    void testPricingStrategies() {
        double basePrice = 100.0;
        assertEquals(100.0, new StandardPricingStrategy().calculatePrice(basePrice));
        assertEquals(80.0, new EarlyBirdPricingStrategy().calculatePrice(basePrice));
        assertEquals(150.0, new SurgeDemandPricingStrategy(new FakeWeatherProvider(true)).calculatePrice(basePrice));
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.0, 50.0, 100.0, 250.0})
    void testPriceIsNeverNegativeAcrossAllStrategies(double basePrice) {
        WeatherProvider fakeWeather = new FakeWeatherProvider(false);
        List<PricingStrategy> strategies = Arrays.asList(
                new StandardPricingStrategy(),
                new EarlyBirdPricingStrategy(),
                new SurgeDemandPricingStrategy(fakeWeather)
        );

        for (PricingStrategy strategy : strategies) {
            assertTrue(strategy.calculatePrice(basePrice) > 0, "Price should always be positive");
        }
    }

    @Test
    void testPricingSelectorRules() {
        assertTrue(PricingSelector.selectStrategy(40, false, null) instanceof EarlyBirdPricingStrategy);
        assertTrue(PricingSelector.selectStrategy(5, true, new FakeWeatherProvider(false)) instanceof SurgeDemandPricingStrategy);
        assertTrue(PricingSelector.selectStrategy(5, false, null) instanceof StandardPricingStrategy);
    }

    @Test
    void testAllocationStrategies() {
        List<String> seats = Arrays.asList("VIP-1", "A10", "BALCONY-1");
        assertEquals("VIP-1", new BestViewAllocationStrategy().allocateSeat(seats, 1));
        assertEquals("BALCONY-1", new BudgetFirstAllocationStrategy().allocateSeat(seats, 1));
    }
}