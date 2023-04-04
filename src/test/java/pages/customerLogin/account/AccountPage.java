package pages.customerLogin.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class AccountPage extends PageBase {
    Wait wait;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@ng-click='byebye()']")
    protected WebElement logoutButton;

    @FindBy(xpath = "//button[normalize-space()='Transactions']")
    protected WebElement transactionsButton;

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    protected WebElement depositButton;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    protected WebElement withdrawButton;


    @FindBy(xpath = "//select[@id='accountSelect']")
    protected WebElement accountSelect;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(logoutButton);
        wait.forVisibility(transactionsButton);
        wait.forVisibility(depositButton);
        wait.forVisibility(withdrawButton);
        wait.forVisibility(accountSelect);
    }


    public void clickLogOutButton() {
        click(logoutButton);
    }

    public void clickTransactionsButton() {
        click(transactionsButton);
    }

    public void clickDepositButton() {
        click(depositButton);
    }

    public void clickWithdrawButton() {
        click(withdrawButton);
    }

    public void selectCurrencyAccount(String accountId) {
        selectOption(accountId, accountSelect);
    }
}
