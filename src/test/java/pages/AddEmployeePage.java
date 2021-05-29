package pages;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy (id ="firstName")
    public WebElement firstName;

    @FindBy (id ="middleName")
    public WebElement middleName;

    @FindBy (id ="lastName")
    public WebElement lastName;

    @FindBy (id ="employeeId")
    public WebElement employeeId;

    @FindBy (id ="btnSave")
    public WebElement saveBtn;

    @FindBy (id ="chkLogin")
    public WebElement createLoginCheckBox;

    public AddEmployeePage (){
        PageFactory.initElements(driver,this);
    }

}
