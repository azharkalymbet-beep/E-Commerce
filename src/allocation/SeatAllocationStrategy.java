package allocation;

import java.util.List;

public interface SeatAllocationStrategy {
    String allocateSeat(List<String> availableSeats, int groupSize);
}