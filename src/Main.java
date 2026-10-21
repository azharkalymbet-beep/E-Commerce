import pricing.*;
import allocation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherProvider weather = new SimulatedWeatherProvider(true);
        List<String> seats = Arrays.asList("VIP-1", "A10", "B5", "BALCONY-12");

        System.out.println("=== Assignment 5: Concert Ticketing Strategy Pattern Demo ===");
        System.out.println("1. Demonstrate All Pricing Strategies on Base Price ($100)");
        System.out.println("2. Dynamic Strategy Switching (Runtime Choice)");
        System.out.println("3. Automatic Selector Selection");
        System.out.print("Select option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                double base = 100.0;
                System.out.println("Standard: $" + new StandardPricingStrategy().calculatePrice(base));
                System.out.println("EarlyBird: $" + new EarlyBirdPricingStrategy().calculatePrice(base));
                System.out.println("Surge (Bad Weather): $" + new SurgeDemandPricingStrategy(weather).calculatePrice(base));
                break;

            case "2":
                PricingContext context = new PricingContext(new StandardPricingStrategy());
                System.out.println("Initial Strategy (Standard): $" + context.executePricing(100.0));

                context.setStrategy(new EarlyBirdPricingStrategy());
                System.out.println("Switched Strategy at Runtime (EarlyBird): $" + context.executePricing(100.0));
                break;

            case "3":
                System.out.print("Enter days before concert (e.g. 40 for EarlyBird): ");
                int days = Integer.parseInt(scanner.nextLine());
                PricingStrategy autoStrategy = PricingSelector.selectStrategy(days, false, weather);
                PricingContext autoContext = new PricingContext(autoStrategy);
                System.out.println("Selected Strategy Calculated Price: $" + autoContext.executePricing(100.0));
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}