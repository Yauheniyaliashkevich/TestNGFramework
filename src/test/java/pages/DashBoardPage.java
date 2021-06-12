package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashBoardPage extends CommonMethods {

    @FindBy (id = "welcome")
    public WebElement welcomeMessage;

    @FindBy (xpath = "//b[text()='PIM']") //(id= "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy (id= "menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy (id= "menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    public DashBoardPage (){
        PageFactory.initElements(driver,this);
    }

}
