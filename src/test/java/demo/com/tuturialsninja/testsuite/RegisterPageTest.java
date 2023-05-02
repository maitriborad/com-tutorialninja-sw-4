package demo.com.tuturialsninja.testsuite;

import demo.com.tuturialsninja.pages.HomePage;
import demo.com.tuturialsninja.pages.RegisterPage;
import demo.com.tuturialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("prime" + getAlphaNumericString(4));
        registerPage.enterLastName("test" + getAlphaNumericString(4));
        registerPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        registerPage.enterPhoneNumber("07988112233");
        registerPage.enterPassword("test123");
        registerPage.enterConfirmPassword("test123");
        registerPage.selectSubscribe("Yes");
        registerPage.clickOnPrivacyPolicy();
        registerPage.clickOnContinueButton();
        Assert.assertEquals(registerPage.getSuccessMessage(),"Your Account Has Been Created!","Registration is not successful");
        registerPage.clickOnContinue();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(homePage.getLogoutMessage(),"Account Logout","Log out not done");
        registerPage.clickOnContinue();
    }
}
