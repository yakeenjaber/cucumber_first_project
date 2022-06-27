package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarvanaCarFinderPage {
    public CarvanaCarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='leftSide']/h1")
    public WebElement heading1;

    @FindBy(css = "h3[role='presentation']")
    public WebElement heading2;

    @FindBy(linkText = "TRY CAR FINDER")
    public WebElement tryCarFinder;
}
