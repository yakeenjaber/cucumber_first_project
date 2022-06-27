package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.ActionsUtil;
import utilities.Driver;
import utilities.DropdownHandler;
import utilities.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaCarFinderPage carvanaCarFinderPage;
    CarvanaHelpMePage carvanaHelpMePage;
    CarvanaSellCarPage carvanaSellCarPage;
    CarvanaLoanCalculatorPage carvanaLoanCalculatorPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaHelpMePage = new CarvanaHelpMePage();
        carvanaSellCarPage = new CarvanaSellCarPage();
        carvanaLoanCalculatorPage = new CarvanaLoanCalculatorPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String button){
        switch (button){
            case ("CAR FINDER") :
                Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.carFinderLink, 4);
                carvanaHomePage.carFinderLink.click();
                break;
            case ("SELL/TRADE") :
                Waiter.pause(2);
                carvanaHomePage.sell_TradeLink.click();
                break;
            case ("AUTO LOAN CALCULATOR") :
                Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.autoLoanCalculatorLink, 4);
                carvanaHomePage.autoLoanCalculatorLink.click();
                break;

        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        switch (url) {
            case "https://www.carvana.com/help-me-search/":
            case "https://www.carvana.com/sell-my-car":
            case "https://www.carvana.com/help-me-search/qa":
                Assert.assertEquals(url, driver.getCurrentUrl());
                break;
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaCarFinderPage.heading1.isDisplayed());
                Assert.assertEquals(text, carvanaCarFinderPage.heading1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaCarFinderPage.heading2.isDisplayed());
                Assert.assertEquals(text, carvanaCarFinderPage.heading2.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaHelpMePage.heading1.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMePage.heading1.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaHelpMePage.heading2.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMePage.heading2.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(carvanaSellCarPage.heading1.isDisplayed());
                Assert.assertEquals(text, carvanaSellCarPage.heading1.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSellCarPage.heading2.isDisplayed());
                Assert.assertEquals(text, carvanaSellCarPage.heading2.getText());
                break;
            case "We couldn't find that VIN. Please check your entry and try again.":
                break;
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String linkText) {
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinder.isDisplayed());
        Assert.assertEquals(linkText, carvanaCarFinderPage.tryCarFinder.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        if ("TRY CAR FINDER".equals(link)) {
            carvanaCarFinderPage.tryCarFinder.click();
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "VIN":
                Waiter.pause(1);
                carvanaSellCarPage.vinButton.click();
                break;
            case "GET MY OFFER":
                carvanaSellCarPage.offerButton.click();
                break;
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String string) {
        carvanaSellCarPage.vinInput.sendKeys(string);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String button) {
        Assert.assertEquals(button, carvanaHomePage.financingMenuButton.getText());
        Waiter.pause(3);
        ActionsUtil.moveToElement(carvanaHomePage.financingMenuButton);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String inputBox, String input) {
        switch (inputBox) {
            case "Cost of Car I want":
                carvanaLoanCalculatorPage.costOfCarInputBox.sendKeys(input);
                break;
            case "What is Your Down Payment?":
                carvanaLoanCalculatorPage.downPayment.sendKeys(input);
                break;
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String box, String selection) {
        switch (box) {
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByVisibleText(carvanaLoanCalculatorPage.creditScoreBox, selection);
                break;
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByVisibleText(carvanaLoanCalculatorPage.loanTerm, selection);
                break;
        }

    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String arg) {
        Assert.assertTrue(carvanaLoanCalculatorPage.monthlyPayment.isDisplayed());
        Assert.assertEquals(arg, carvanaLoanCalculatorPage.monthlyPayment.getText());

    }
}
