package pages.customerLogin.account.enums;

public enum Currency {
    DOLLAR("Dollar"),
    POUND("Pound"),
    RUPEE("Rupee");

    public String currency;

    Currency(String currency) {
        this.currency = currency;

    }

    public String getCurrency() {
        return currency;
    }
}
