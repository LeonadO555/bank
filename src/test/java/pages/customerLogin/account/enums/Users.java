package pages.customerLogin.account.enums;

public enum Users {
    DUMBLEDORE("Albus Dumbledore"),
    RON("Ron Weasly"),
    POTTER("Harry Potter");

    public String name;

    Users(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
