package pages.customerLogin.account.withdrawl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class WithdrawPage extends PageBase {
    public WithdrawPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement depositButtomConfirm;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(depositButtomConfirm);
    }

    public void clickOnDepositButtonConfirm() {
        click(depositButtomConfirm);
    }
}
