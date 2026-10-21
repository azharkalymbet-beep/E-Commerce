package allocation;

import java.util.List;

public class AllocationContext {
    private SeatAllocationStrategy strategy;

    public AllocationContext(SeatAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SeatAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeAllocation(List<String> seats, int groupSize) {
        return strategy.allocateSeat(seats, groupSize);
    }
}