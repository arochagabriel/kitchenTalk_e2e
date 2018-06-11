package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class RegisterPage {

    @FindBy(className = "page-title")
    public static WebElement registerTitle;

    @FindBy(className = "male")
    public static WebElement maleGenderOption;

    @FindBy(className = "female")
    public static WebElement femaleGenderOption;

    @FindBy(id = "FirstName")
    public static WebElement firstNameInput;

    @FindBy(id = "LastName")
    public static WebElement lastNameInput;

    @FindBy(id = "Email")
    public static WebElement emailInput;

    @FindBy(id = "ConfirmPassword")
    public static WebElement confirmPasswordInput;

    @FindBy(id = "Password")
    public static WebElement passwordInput;

    @FindBy(name = "register-button")
    public static WebElement registerButton;

    @FindBy(className = "result")
    public static WebElement resultInfo;

    @FindBy(name="register-continue")
    public static WebElement continueButton;


    public static class DayOfBirth {

        @FindBy(name = "DateOfBirthDay")
        public static WebElement openDayList;

        @FindBy(tagName = "option")
        public static List<WebElement> selectDay;

        @FindBy(name = "DateOfBirthMonth")
        public static WebElement openMonthList;

        @FindBy(tagName = "option")
        public static List<WebElement> selectMonth;

        @FindBy(name = "DateOfBirthYear")
        public static WebElement openYearList;

        @FindBy(tagName = "option")
        public static List<WebElement> selectYear;
    }


}
