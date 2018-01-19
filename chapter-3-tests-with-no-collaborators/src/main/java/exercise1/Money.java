package exercise1;

public class Money {
    private final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean equals(Object other) {
        if (other instanceof Money) {
            final Money money = (Money) other;
            return money.getCurrency().equals(this.getCurrency())
                    && this.getAmount() == money.getAmount();
        }

        return false;
    }
}