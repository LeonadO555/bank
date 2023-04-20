package tests.withdraw;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import pages.customerLogin.account.deposit.DepositPage;
import pages.customerLogin.account.transactions.TransactionsPage;
import pages.customerLogin.account.withdrawl.WithdrawPage;
import tests.TestBase;

public class MakeWithdrawTest extends TestBase {
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    DepositPage depositPage;
    TransactionsPage transactionsPage;
    WithdrawPage withdrawPage;

    String customerName = "Ron Weasly";
    String accountNumber = "1007";
    String depositSum = "10000";
    String withdrawSum = "200";

    @Test
    public void verifyWithdrawFunctional() {
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();

        customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.selectExistingUser(customerName);
        customerLoginPage.checkForVisibilityLoginButton();
        customerLoginPage.clickOnLoginButton();

        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();
        accountPage.selectCurrencyAccount(accountNumber);
        accountPage.clickDepositButton();

        depositPage = new DepositPage(app.driver);
        depositPage.waitForLoading();
        depositPage.fillAmountField(depositSum);
        depositPage.clickOnDepositButtonConfirm();

        accountPage.clickWithdrawButton();

        withdrawPage = new WithdrawPage(app.driver);
        withdrawPage.waitForLoading();
        withdrawPage.setAmountToBeWithdrawnSelector(withdrawSum);
        withdrawPage.clickOnWithdrawButton();

        withdrawPage.checkTransactionSuccessfulMessage();

    }
}
