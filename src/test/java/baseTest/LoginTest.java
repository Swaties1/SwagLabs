package baseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.utility.DataProviders;

public class LoginTest extends BaseClass{
	
LoginPage loginPage;
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void loginTest(String username, String Password) {
        
        
        loginPage = new LoginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(Password);
        loginPage.clickLoginButton();
        boolean loginSuccess = loginPage.isLoginSuccessful();

        // Assert that login was successful
        if (loginSuccess) {
            Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Expected login to succeed for user: " + username
            );
        } else {
            Assert.assertTrue(
                loginPage.isLoginFailed(),
                "Expected login to fail for user: " + username
            );
    }
}
}