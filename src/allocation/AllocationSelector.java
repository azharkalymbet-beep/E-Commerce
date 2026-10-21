package allocation;

public class AllocationSelector {
    public static SeatAllocationStrategy selectStrategy(int groupSize, boolean isVIP, boolean isBudget) {
        if (groupSize > 1) {
            return new GroupAdjacentAllocationStrategy();
        } else if (isVIP) {
            return new BestViewAllocationStrategy();
        } else if (isBudget) {
            return new BudgetFirstAllocationStrategy();
        } else {
            return new BestViewAllocationStrategy();
        }
    }
}