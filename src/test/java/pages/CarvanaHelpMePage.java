package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarvanaHelpMePage {
    public CarvanaHelpMePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@data-qa='headline']")
    public WebElement heading1;

    @FindBy(xpath = "//div[@data-qa='sub-heading']")
    public WebElement heading2;



}
