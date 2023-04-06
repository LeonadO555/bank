package tests.account;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import pages.customerLogin.account.deposit.DepositPage;
import pages.customerLogin.account.transactions.TransactionsPage;
import tests.TestBase;

public class DepositExistCustomerTest extends TestBase {

    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    DepositPage depositPage;
    TransactionsPage transactionsPage;


    String userName = "Albus Dumbledore";
    String currencyAccountDollar = "1010";
    //String currencyAccountPound = "1011";
    //String currencyAccountRupee = "1012";
    String amount = "50";
    String expectedResultDefault = "Account Number : 1010 , Balance : 0 , Currency : Dollar";
    String expectedResultAfterDeposit = "Account Number : 1010 , Balance : 50 , Currency : Dollar";

    String transactionType = "Credit";


    @Test
    public void DepositExistCustomerWithValidDataTest() {
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();

        customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.selectExistingUser(userName);
        customerLoginPage.checkForVisibilityLoginButton();
        customerLoginPage.clickOnLoginButton();

        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();
        accountPage.selectCurrencyAccount("1010");
        accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);
        accountPage.clickDepositButton();

        depositPage = new DepositPage(app.driver);
        depositPage.waitForLoading();
        depositPage.fillAmountField(amount);
        depositPage.clickOnDepositButtonConfirm();
        depositPage.checkForVisibilityDepositSuccessful();

        accountPage.checkAccountNumberBalanceCurrencyText(expectedResultAfterDeposit);
        accountPage.clickTransactionsButton();


        transactionsPage = new TransactionsPage(app.driver);
        transactionsPage.waitForLoading();
        transactionsPage.checkTransactionType(transactionType);
        transactionsPage.checkAmount(amount);
        transactionsPage.clickOnResetButton();
        transactionsPage.clickOnBackButton();

        accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);


    }

}
