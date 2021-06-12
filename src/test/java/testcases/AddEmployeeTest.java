package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeTest extends CommonMethods {
    @Test(groups = "regression")
    public void addMultipleEmployee() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.getPropertiesValue("username"), ConfigReader.getPropertiesValue("password"));
        //navigating to add employee page
        DashBoardPage dash = new DashBoardPage();
        EmployeeListPage empList = new EmployeeListPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, "EmployeeData");
        SoftAssert softAssert = new SoftAssert();
        Iterator<Map<String, String>> it = newEmployees.iterator();
        while (it.hasNext()) {
            click(dash.pimOption);
            Thread.sleep(2000);
            click(dash.addEmployeeButton);
            Map<String, String> mapNewEmployee = it.next();
            sendText(addEmployeePage.firstName, mapNewEmployee.get("FirstName"));
            sendText(addEmployeePage.middleName, mapNewEmployee.get("MiddleName"));
            sendText(addEmployeePage.lastName, mapNewEmployee.get("LastName"));
            String employeeIDValue = addEmployeePage.employeeId.getAttribute("value");
            sendText(addEmployeePage.photograph, mapNewEmployee.get("Photograph"));
            //select checkBox
            if (!addEmployeePage.createLoginCheckBox.isSelected()) {
                click(addEmployeePage.createLoginCheckBox);
            }
            //add login credentials for user
            sendText(addEmployeePage.usernamecreate, mapNewEmployee.get("UserName"));
            sendText(addEmployeePage.userpassword, mapNewEmployee.get("Password"));
            sendText(addEmployeePage.repassword, mapNewEmployee.get("Password"));
            click(addEmployeePage.saveBtn);
            //navigate to the employee list
            click(dash.pimOption);
            Thread.sleep(2000);
            click(dash.employeeListOption);
            //enter employee id
            //waitForClickability(empList.idEmployee);
            Thread.sleep(2000);
            sendText(empList.idEmployee, employeeIDValue);
            click(empList.searchButton);
            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < rowData.size(); i++) {
                System.out.println("I am inside the loop");
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);
                Thread.sleep(5000);
                String expectedEmployeeDetails = employeeIDValue + " " + mapNewEmployee.get("FirstName") + " " + mapNewEmployee.get("MiddleName") + " " + mapNewEmployee.get("LastName");
                softAssert.assertEquals(rowText, expectedEmployeeDetails);
            }
            softAssert.assertAll();
        }

    }
}
