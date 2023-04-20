package tests.account;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import pages.customerLogin.account.deposit.DepositPage;
import pages.customerLogin.account.transactions.TransactionsPage;
import tests.TestBase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class DepositExistCustomerTest extends TestBase {
    Random random = new Random();
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    DepositPage depositPage;
    TransactionsPage transactionsPage;
    String userName = "Albus Dumbledore";
    Integer amountRandom = random.nextInt(1, 500000);
    Integer amountRandom2 = random.nextInt(500001, 1000000);
    String amountRandomString = amountRandom.toString();
    String amountRandom2String = amountRandom2.toString();
    Integer amountRandomSum = amountRandom + amountRandom2;

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

        LinkedHashMap<String, String> accountsAndCurrency = new LinkedHashMap<>();
        accountsAndCurrency.put("1010", "Dollar");
        accountsAndCurrency.put("1011", "Pound");
        accountsAndCurrency.put("1012", "Rupee");

        for (Map.Entry<String, String> pair : accountsAndCurrency.entrySet()) {
            String account = pair.getKey();
            String currency = pair.getValue();

            accountPage.selectCurrencyAccount(account);
            accountPage.clickDepositButton();
            String expectedResultDefault = "Account Number : " + account + " , Balance : 0" + " , Currency : " + currency;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);

            depositPage = new DepositPage(app.driver);
            depositPage.waitForLoading();
            depositPage.fillAmountField(amountRandomString);
            depositPage.clickOnDepositButtonConfirm();
            depositPage.checkForVisibilityDepositSuccessful();

            String expectedResult = "Account Number : " + account + " , Balance : " + amountRandom + " , Currency : " + currency;

            accountPage.checkAccountNumberBalanceCurrencyText(expectedResult);

            depositPage.fillAmountField(amountRandom2String);
            depositPage.clickOnDepositButtonConfirm();
            depositPage.checkForVisibilityDepositSuccessful();

            String expectedResultSum = "Account Number : " + account + " , Balance : " + amountRandomSum + " , Currency : " + currency;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultSum);

            accountPage.clickTransactionsButton();

            transactionsPage = new TransactionsPage(app.driver);
            transactionsPage.waitForLoading();
            transactionsPage.clickOnResetButton();
            transactionsPage.clickOnBackButton();

            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);
        }
    }

}