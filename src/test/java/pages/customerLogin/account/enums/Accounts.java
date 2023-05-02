package pages.customerLogin.account.enums;

import java.util.LinkedHashMap;

public enum Accounts {
    DUMBLEDORE_DOLLAR(Users.DUMBLEDORE.getName(), "1010", Currency.DOLLAR),
    DUMBLEDORE_POUND(Users.DUMBLEDORE.getName(), "1011", Currency.POUND),
    DUMBLEDORE_RUPEE(Users.DUMBLEDORE.getName(), "1012", Currency.RUPEE),

    RON_DOLLAR(Users.RON.getName(), "1007", Currency.DOLLAR),
    RON_POUND(Users.RON.getName(), "1008", Currency.POUND),
    RON_RUPEE(Users.RON.getName(), "1009", Currency.RUPEE),

    POTTER_DOLLAR(Users.POTTER.getName(), "1004", Currency.DOLLAR),
    POTTER_POUND(Users.POTTER.getName(), "1005", Currency.POUND),
    POTTER_RUPEE(Users.POTTER.getName(), "1006", Currency.RUPEE);

    public String name;
    public String numberOfAccount;
    public String currency;

    Accounts(String name, String numberOfAccount, Currency currency) {
        this.name = name;
        this.numberOfAccount = numberOfAccount;
        this.currency = String.valueOf(currency);
    }

    public String getName() {
        return name;
    }

    public String getNumberOfAccount() {
        return numberOfAccount;
    }

    public String getCurrency() {
        return currency;
    }

    // ???
    public LinkedHashMap generateMapOfAccounts() {
        LinkedHashMap<String, String> accountsOfUser = new LinkedHashMap<>();
        return accountsOfUser;
    }
}


