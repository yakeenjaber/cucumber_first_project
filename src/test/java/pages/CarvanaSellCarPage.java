package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class CarvanaSellCarPage {
    public CarvanaSellCarPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//div[@class='sc-7ed29b82-1 jwFVns']/div[2]")
    public WebElement heading1;

    @FindBy(xpath = "//div[@class='sc-7ed29b82-1 jwFVns']/div[3]")
    public WebElement heading2;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public  WebElement vinButton;

    @FindBy(xpath = "//input[@aria-labelledby='VIN']")
    public WebElement vinInput;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public WebElement offerButton;
}
