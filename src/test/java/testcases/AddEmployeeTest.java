package testcases;

import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class AddEmployeeTest extends CommonMethods {

    @Test (groups = "smoke")
    public void addEmployee (){
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigReader.getPropertiesValue("username"),ConfigReader.getPropertiesValue("password"));

        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
        click(dash.addEmployeeButton);

        AddEmployeePage add= new AddEmployeePage();
        sendTest(add.firstName,"test");
        sendTest(add.lastName, "test12345");
        click(add.saveBtn);




    }

}
