package pages.customerLogin.account.deposit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class DepositPage extends PageBase {

    Wait wait;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(withdraw);
    }

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn-default")
    WebElement withdraw;

    public void clickOnWithdrawButton() {
        click(withdraw);
    }
}

