package actions;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;

import static com.googlecode.totallylazy.matchers.Matchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;

public class Home {


    public static void clickOnRegister(WebDriver driver) {
        PageFactory.initElements(driver, HomePage.HeaderUpper.class);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(HomePage.HeaderUpper.registerBtn));
        HomePage.HeaderUpper.registerBtn.click();
    }

    public static void checkIfIamLogged(WebDriver driver){
        PageFactory.initElements(driver, HomePage.HeaderUpper.class);
        new WebDriverWait(driver,30).until((ExpectedConditions.visibilityOf(HomePage.HeaderUpper.myAccountTitleButton)));
        assertThat(HomePage.HeaderUpper.myAccountTitleButton.getText(), hasToString(equalTo("My account")));
    }
}

