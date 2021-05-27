package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTest extends CommonMethods {

    @Test
    public void adminLogin(){

        LoginPage loginPage=new LoginPage();
        sendTest(loginPage.usernameBox, ConfigReader.getPropertiesValue("username"));
        sendTest(loginPage.passwordBox, ConfigReader.getPropertiesValue("password"));
        click(loginPage.loginBtn);

        //validation
        //assertion

        DashBoardPage dashBoardPage=new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed(), "welcome message is not displayed");
    }


}
