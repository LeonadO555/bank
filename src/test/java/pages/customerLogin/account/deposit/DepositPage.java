package pages.customerLogin.account.deposit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class DepositPage extends PageBase {
    public DepositPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement depositButtomConfirm;

    @FindBy(xpath = "//strong[2]")
    protected WebElement balance;

    @FindBy(xpath = "//input[@placeholder='amount']")
    protected WebElement amountField;


    @FindBy(xpath = "//span[@class='error ng-binding']")
    protected WebElement depositSuccessful;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(depositButtomConfirm);
        wait.forVisibility(amountField);
    }

    public void fillAmountField(String amount) {
        fillField(amountField, amount);
    }

    public String getBalance() {
        String balanceText = balance.getText();
        return balanceText;
    }


    public void clickOnDepositButtonConfirm() {
        click(depositButtomConfirm);
    }

    public void checkForVisibilityDepositSuccessful() {
        wait.forVisibility(depositSuccessful);
    }

}
