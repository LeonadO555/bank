package pages.customerLogin.account.withdrawl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class WithdrawPage extends PageBase {
    Wait wait;

    public WithdrawPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(amountToBeWithdrawnSelector);
    }

    @FindBy(xpath = "//input[@placeholder='amount']")
    protected WebElement amountToBeWithdrawnSelector;

    public void setAmountToBeWithdrawnSelector(WebElement element, String number) {
        amountToBeWithdrawnSelector.clear();
        amountToBeWithdrawnSelector.sendKeys(number);
    }
}
