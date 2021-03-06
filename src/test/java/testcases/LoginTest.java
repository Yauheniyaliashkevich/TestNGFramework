package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTest extends CommonMethods {

    @Test (groups = "sanity")
    public void adminLogin(){

        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernameBox, ConfigReader.getPropertiesValue("username"));
        sendText(loginPage.passwordBox, ConfigReader.getPropertiesValue("password"));
        click(loginPage.loginBtn);

        //validation
        //assertion

        DashBoardPage dashBoardPage=new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed(), "welcome message is not displayed");
    }

    @Test (dataProvider = "invalidData", groups = "smoke")
    public void invalidLoginErrorMessageValidation (String username, String password, String message){
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernameBox,username);
        sendText(loginPage.passwordBox,password);
        click(loginPage.loginBtn);

        String actualError = loginPage.errorMessage.getText();
        Assert.assertEquals(actualError,message, "Error message is not matched");

    }

    @DataProvider
    public Object [][] invalidData(){
        Object[][] data={
                {"James","123!","Invalid credentials"},
                {"Admin1","Syntax123!","Invalid credentials"},
                {"James","","Password cannot be empty"},
                {"","Syntax123!","Username cannot be empty"}
        };
        return data;
    }





}
