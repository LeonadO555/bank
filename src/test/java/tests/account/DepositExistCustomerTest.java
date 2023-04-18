package tests.account;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import pages.customerLogin.account.deposit.DepositPage;
import pages.customerLogin.account.transactions.TransactionsPage;
import tests.TestBase;

import java.util.Random;

public class DepositExistCustomerTest extends TestBase {
    Random random = new Random();
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    DepositPage depositPage;
    TransactionsPage transactionsPage;
    String userName = "Albus Dumbledore";
    String[] accountsArray = {"1010", "1011", "1012"};
    Integer amountRandom = random.nextInt(1, 100000000);
    String amountRandomString = amountRandom.toString();
    String typeOfAccount;

    @Test
    public void DepositExistCustomerWithValidDataTest() throws InterruptedException {
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

        for (String account : accountsArray) {

            if (account == accountsArray[0]) {
                typeOfAccount = "Dollar";
            } else if (account == accountsArray[1]) {
                typeOfAccount = "Pound";
            } else typeOfAccount = "Rupee";
            accountPage.selectCurrencyAccount(account);
            accountPage.clickDepositButton();
            String expectedResultDefault = "Account Number : " + account + " , Balance : 0" + " , Currency : " + typeOfAccount;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);

            depositPage = new DepositPage(app.driver);
            depositPage.waitForLoading();
            depositPage.fillAmountField(amountRandomString);
            depositPage.clickOnDepositButtonConfirm();
            depositPage.checkForVisibilityDepositSuccessful();

            String expectedResult = "Account Number : " + account + " , Balance : " + amountRandom + " , Currency : " + typeOfAccount;

            accountPage.checkAccountNumberBalanceCurrencyText(expectedResult);
            accountPage.clickTransactionsButton();

            transactionsPage = new TransactionsPage(app.driver);
            transactionsPage.waitForLoading();
            transactionsPage.clickOnResetButton();
            transactionsPage.clickOnBackButton();

            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);

        }
    }

}