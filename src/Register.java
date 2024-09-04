import java.util.Arrays;
import java.util.List;

public class Register {
    private final List<Denomination> denominations;


    //Initializes all Denominations
    public Register() {
        denominations = Arrays.asList(
                new Denomination("Hundred Note", 100.0, "bill", "images/hundred_note.png"),
                new Denomination("Fifty Note", 50.0, "bill", "images/fifty_note.png"),
                new Denomination("Twenty Note", 20.0, "bill", "images/twenty_note.png"),
                new Denomination("Ten Note", 10.0, "bill", "images/ten_note.png"),
                new Denomination("Five Note", 5.0, "bill", "images/five_note.png"),
                new Denomination("One Note", 1.0, "bill", "images/one_note.png"),
                new Denomination("Quarter", 0.25, "coin", "images/quarter.png"),
                new Denomination("Dime", 0.10, "coin", "images/dime.png"),
                new Denomination("Nickel", 0.05, "coin", "images/nickel.png"),
                new Denomination("Penny", 0.01, "coin", "images/penny.png")
        );
    }

    //I found resizing the images being the easiest way to display correctly

    // Makes change by calculating the least number of bills/coins for the given amount
    public Purse makeChange(double amount) {
        Purse purse = new Purse();
        for (Denomination denomination : denominations) {
            int count = (int) (amount / denomination.amt());
            if (count > 0) {
                purse.add(denomination, count);
                amount -= denomination.amt() * count;
                amount = Math.round(amount * 100.0) / 100.0; // Rounding to avoid floating-point precision issues
            }
        }
        return purse;
    }

    public List<Denomination> getDenominations() {
        return denominations;
    }
}

