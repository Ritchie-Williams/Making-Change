import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash;

    //Initializes new HashMap "cash"
    public Purse() {
        cash = new HashMap<>();
    }

    // Adds denomination to the purse
    public void add(Denomination denomination, int count) {
        cash.put(denomination, cash.getOrDefault(denomination, 0) + count);
    }

    // Removes denomination from the purse
    public double remove(Denomination denomination, int count) {
        int currentCount = cash.getOrDefault(denomination, 0);
        int removeCount = Math.min(currentCount, count);
        cash.put(denomination, currentCount - removeCount);
        return denomination.amt() * removeCount;
    }

    // Calculates total value of the purse
    public double getValue() {
        return cash.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().amt() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getKey().name()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    // Method to get the cash entries (used in PursePanel)
    public Map<Denomination, Integer> getCashEntries() {
        return cash;
    }
}
