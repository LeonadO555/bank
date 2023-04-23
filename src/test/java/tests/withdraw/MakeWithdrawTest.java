package tests.withdraw;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;
import pages.customerLogin.account.deposit.DepositPage;
import pages.customerLogin.account.transactions.TransactionsPage;
import pages.customerLogin.account.withdrawl.WithdrawPage;
import tests.TestBase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class MakeWithdrawTest extends TestBase {
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    DepositPage depositPage;

    TransactionsPage transactionsPage;
    WithdrawPage withdrawPage;

    String customerName = "Ron Weasly";
    Random random = new Random();
    Integer amountDepositRandom = random.nextInt(10000, 1000000);
    Integer amountWithdrawRandom = random.nextInt(1, 50000);

    Integer amountWithdrawRandom2 = random.nextInt(1, 30000);
    String amountDepositRandomString = amountDepositRandom.toString();

    String amountWithdrawRandomString = amountWithdrawRandom.toString();

    String amountWithdrawRandom2String = amountWithdrawRandom2.toString();

    Integer amountRandomResSum = amountDepositRandom - amountWithdrawRandom;

    Integer amountRandomResSum2 = amountRandomResSum - amountWithdrawRandom2;

    String amountRandomResSum2String = amountRandomResSum2.toString();


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

        LinkedHashMap<String, String> accountsAndCurrency = new LinkedHashMap<>();
        accountsAndCurrency.put("1007", "Dollar");
        accountsAndCurrency.put("1008", "Pound");
        accountsAndCurrency.put("1009", "Rupee");

        for (Map.Entry<String, String> pair : accountsAndCurrency.entrySet()) {
            String account = pair.getKey();
            String currency = pair.getValue();

            accountPage.selectCurrencyAccount(account);
            accountPage.clickDepositButton();
            String expectedResultDefault = "Account Number : " + account + " , Balance : 0" + " , Currency : " + currency;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);

            depositPage = new DepositPage(app.driver);
            depositPage.waitForLoading();
            depositPage.fillAmountField(amountDepositRandomString);
            depositPage.clickOnDepositButtonConfirm();
            depositPage.checkForVisibilityDepositSuccessful();

            String expectedResult = "Account Number : " + account + " , Balance : " + amountDepositRandom + " , Currency : " + currency;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResult);

            accountPage.clickWithdrawButton();
            withdrawPage = new WithdrawPage(app.driver);
            withdrawPage.fillAmountWithdrawField(amountWithdrawRandomString);
            withdrawPage.clickOnWithdrawButton();
            withdrawPage.checkTransactionSuccessfulMessage();

            String expectedResultAfterWithdraw = "Account Number : " + account + " , Balance : " + amountRandomResSum + " , Currency : " + currency;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultAfterWithdraw);

            withdrawPage.fillAmountWithdrawField(amountWithdrawRandom2String);
            withdrawPage.clickOnWithdrawButton();
            withdrawPage.checkTransactionSuccessfulMessage();

            String expectedResultAfterWithdraw2 = "Account Number : " + account + " , Balance : " + amountRandomResSum2 + " , Currency : " + currency;
            accountPage.checkAccountNumberBalanceCurrencyText(expectedResultAfterWithdraw2);

            accountPage.clickTransactionsButton();

            transactionsPage = new TransactionsPage(app.driver);
            transactionsPage.waitForLoading();

            Assert.assertEquals(amountRandomResSum2String, transactionsPage.getAmount());

            //transactionsPage.clickOnResetButton();
            //transactionsPage.clickOnBackButton();

            //accountPage.checkAccountNumberBalanceCurrencyText(expectedResultDefault);

        }

    }
}
