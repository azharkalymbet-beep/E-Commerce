package allocation;

import java.util.List;

public class BudgetFirstAllocationStrategy implements SeatAllocationStrategy {
    @Override
    public String allocateSeat(List<String> availableSeats, int groupSize) {
        return availableSeats.stream()
                .filter(s -> s.startsWith("BALCONY") || s.startsWith("C"))
                .findFirst()
                .orElse(availableSeats.get(availableSeats.size() - 1));
    }
}