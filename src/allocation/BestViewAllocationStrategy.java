package allocation;

import java.util.List;

public class BestViewAllocationStrategy implements SeatAllocationStrategy {
    @Override
    public String allocateSeat(List<String> availableSeats, int groupSize) {
        return availableSeats.stream()
                .filter(s -> s.startsWith("VIP") || s.startsWith("A"))
                .findFirst()
                .orElse(availableSeats.get(0));
    }
}