package actions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.RegisterPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class Register {

    public static void checkTitle(WebDriver driver) {
        PageFactory.initElements(driver, RegisterPage.class);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(RegisterPage.registerTitle));
        RegisterPage.registerTitle.isDisplayed();
    }

    public static void genderOption(WebDriver driver, String arg1) {
        PageFactory.initElements(driver, RegisterPage.class);
        switch (arg1) {
            case "Male":
                RegisterPage.maleGenderOption.click();
                break;
            default:
                RegisterPage.femaleGenderOption.click();
                break;
        }


    }

    public static void enterFirstNameAndLastName(WebDriver driver, String arg1, String arg2) {
        PageFactory.initElements(driver, RegisterPage.class);
        RegisterPage.firstNameInput.sendKeys(arg1);
        RegisterPage.lastNameInput.sendKeys(arg2);
    }

    public static void selectDayOfBirth(WebDriver driver, String arg1, String arg2, String arg3) {
        PageFactory.initElements(driver, RegisterPage.DayOfBirth.class);
        RegisterPage.DayOfBirth.openDayList.click();
        for (WebElement day : RegisterPage.DayOfBirth.selectDay) {
            if (day.getText().equals(arg1)) {
                day.click();
                break;
            }
        }
        RegisterPage.DayOfBirth.openMonthList.click();
        for (WebElement month : RegisterPage.DayOfBirth.selectMonth) {
            if (month.getText().equals(arg2)) {
                month.click();
                break;
            }
        }
        RegisterPage.DayOfBirth.openYearList.click();
        for (WebElement year : RegisterPage.DayOfBirth.selectYear) {
            if (year.getText().equals(arg3)) {
                year.click();
                break;
            }
        }
    }

    public static void inputEmail(WebDriver driver, String arg1) {
        PageFactory.initElements(driver, RegisterPage.class);
        RegisterPage.emailInput.sendKeys(arg1);
    }

    public static void enterAndConfirmPassword(WebDriver driver, String arg1) {
        PageFactory.initElements(driver, RegisterPage.class);
        RegisterPage.passwordInput.sendKeys(arg1);
        RegisterPage.confirmPasswordInput.sendKeys(arg1);
    }

    public static void clickOnRegisterButton(WebDriver driver) {
        PageFactory.initElements(driver, RegisterPage.class);
        RegisterPage.registerButton.click();
    }

    public static void showSuccessfulMessageAndClickOnContinue(WebDriver driver, String arg1) throws Exception{
        PageFactory.initElements(driver, RegisterPage.class);
        assertThat(RegisterPage.resultInfo.getText(), is(equalTo(arg1)));
        RegisterPage.continueButton.click();
    }
}
