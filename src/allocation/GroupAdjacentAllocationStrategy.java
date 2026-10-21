package allocation;

import java.util.List;

public class GroupAdjacentAllocationStrategy implements SeatAllocationStrategy {
    @Override
    public String allocateSeat(List<String> availableSeats, int groupSize) {
        return "GROUP_ZONE_ROW_" + groupSize + " (" + String.join(", ", availableSeats.subList(0, Math.min(groupSize, availableSeats.size()))) + ")";
    }
}