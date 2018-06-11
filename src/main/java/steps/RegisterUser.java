package steps;

import actions.Home;
import actions.Register;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;


public class RegisterUser {


    public WebDriver driver;

    public RegisterUser() {

        driver = WebDriverProducer.driver;
    }

    @When("^I click on Register button in the top menu$")
    public void iClickOnRegisterButtonInTheTopMenu() throws Throwable {
        Home.clickOnRegister(driver);
    }

    @Then("^a form must to be shown$")
    public void aFormMustToBeShown() throws Throwable {
        Register.checkTitle(driver);
    }

    @Then("^I select \"([^\"]*)\" as gender$")
    public void iSelectAsGender(String arg1) throws Throwable {
        Register.genderOption(driver, arg1);
    }

    @Then("^I write my name: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iWriteMyName(String arg1, String arg2) throws Throwable {
        Register.enterFirstNameAndLastName(driver, arg1, arg2);
    }

    @Then("^I choose my date of birth: day \"([^\"]*)\", month \"([^\"]*)\", year \"([^\"]*)\"$")
    public void iChooseMyDateOfBirthDayMonthYear(String arg1, String arg2, String arg3) throws Throwable {
        Register.selectDayOfBirth(driver, arg1, arg2, arg3);
    }

    @Then("^I enter my email \"([^\"]*)\"$")
    public void iEnterMyEmail(String arg1) throws Throwable {
        Register.inputEmail(driver, arg1);
    }

    @Then("^I set and confirm my password \"([^\"]*)\"$")
    public void iSetAndConfirmMyPassword(String arg1) throws Throwable {
        Register.enterAndConfirmPassword(driver, arg1);
    }


    @Then("^I click on Register button$")
    public void iClickOnRegisterButton() throws Throwable {
        Register.clickOnRegisterButton(driver);
    }

    @Then("^I should be redirect to a message \"([^\"]*)\" and click on Continue button$")
    public void iShouldBeRedirectToAMessageAndClickOnContinueButton(String arg1) throws Throwable {
      Register.showSuccessfulMessageAndClickOnContinue(driver, arg1);
    }

    @Then("^return logged to the homepage$")
    public void returnLoggedToTheHomepage() throws Throwable {
       Home.checkIfIamLogged(driver);
    }

}
