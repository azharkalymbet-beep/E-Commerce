# Assignment 5: Strategy Design Pattern (Concert Ticketing Domain)

## 1. Class Responsibilities Table (Single Responsibility Principle)
*Note: Each description is under 25 words and avoids "if", "and", "or", "but".*

| Class | Responsibility |
| :--- | :--- |
| `PricingStrategy` | Defines the contractual method interface for calculating concert ticket costs. |
| `StandardPricingStrategy` | Calculates default ticket prices without modifications. |
| `EarlyBirdPricingStrategy` | Applies promotional discount pricing for advance purchases. |
| `SurgeDemandPricingStrategy` | Computes dynamic price increases based on external environmental factors. |
| `PricingContext` | Maintains active strategy reference, delegating pricing calculations. |
| `PricingSelector` | Automatically instantiates appropriate pricing strategies matching operational parameters. |
| `WeatherProvider` | Defines interface contract isolating external weather data sources. |
| `SeatAllocationStrategy` | Establishes the interface contract for seat selection algorithms. |
| `BestViewAllocationStrategy` | Selects premium seats offering optimal stage visibility. |
| `BudgetFirstAllocationStrategy` | Locates lowest-cost seating options within venue inventories. |
| `GroupAdjacentAllocationStrategy` | Reserves contiguous seat blocks accommodating group reservations. |
| `AllocationContext` | Holds allocation strategy reference, delegating seat selection operations. |
| `AllocationSelector` | Automatically determines optimal allocation strategies based on party size. |

---

## 2. Reflection: Strategy vs. State vs. Template Method

### Architectural Differences
- **Strategy Pattern:** Focuses on making entire algorithms interchangeable via composition. The client or selector explicitly chooses which algorithm strategy to plug into the context at runtime.
- **State Pattern:** Focuses on managing object behavior changes based on internal state transitions. States change automatically from within state classes as execution progresses.
- **Template Method Pattern:** Uses inheritance to define an algorithm skeleton in a superclass, letting subclasses override specific steps without replacing the whole algorithm structure.

### Why Strategy is Right for This Domain
In our Concert Ticketing application, price calculations and seat selections represent complete, independent algorithms rather than state transitions or partial step overrides. The client requires total algorithm interchangeability at runtime based on business rules without subclassing or tracking state changes. Thus, the Strategy pattern is the precise architectural fit.

---

## 3. Refactoring Git Commits
- **Before Refactoring (Monolithic Switch-Case):** `[INSERT_YOUR_GIT_COMMIT_LINK_1_HERE]`
- **After Refactoring (Clean Strategy Pattern):** `[INSERT_YOUR_GIT_COMMIT_LINK_2_HERE]`
