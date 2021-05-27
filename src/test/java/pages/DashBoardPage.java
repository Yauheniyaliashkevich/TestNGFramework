package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashBoardPage extends CommonMethods {

    @FindBy (id = "welcome")
    public WebElement welcomeMessage;

    public DashBoardPage (){
        PageFactory.initElements(driver,this);
    }

}
