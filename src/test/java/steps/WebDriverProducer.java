package steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.PropertyUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverProducer {

    public static WebDriver driver;
    public WebDriverWait wait;
    private static final String GRID_HUB_URL = "http://127.0.1.1:4444/wd/hub";
    private String myUrl = PropertyUtil.getInstance().getProperties().getProperty("url");

    @Before()
    /*
     * Delete all cookies at the start of each scenario to avoid shared state
     * between tests
     */
    public void openBrowser() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new RemoteWebDriver(new URL(GRID_HUB_URL), options);
        wait = new WebDriverWait(driver, 60);
        driver.manage().deleteAllCookies();
        driver.get(myUrl);
    }

    @After()

    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        driver.quit();

    }


}
