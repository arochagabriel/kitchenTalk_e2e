package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  {

    public static class HeaderUpper {
        @FindBy(className = "ico-register")
        public static WebElement registerBtn;

        @FindBy(linkText = "Sign Up")
        public static WebElement loginBtn;

        @FindBy(className = "ico-account")
        public static WebElement myAccountTitleButton;

    }
}
