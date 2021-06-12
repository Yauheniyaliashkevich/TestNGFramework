package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {

    @FindBy (xpath="//*[@name='empsearch[id]']")
    public WebElement idEmployee;

    @FindBy (xpath ="//*[@name='_search']")
    public WebElement searchButton;

    public EmployeeListPage (){
        PageFactory.initElements(driver,this);
    }



}
