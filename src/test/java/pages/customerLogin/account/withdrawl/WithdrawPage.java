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
        wait.forVisibility(withdraw);
    }

    @FindBy(css = ".btn-default")
    WebElement withdraw;

    public void clickOnWithdrawButton() {
        click(withdraw);
    }
}
