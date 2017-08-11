import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features")
public class BaseTest {

    @BeforeClass
    public static void openMainPage() {
        AbstractPage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.getDriver().navigate().to("http://www.sberbank.ru");
    }

    @AfterClass
    public static void quit() {
        AbstractPage.getDriver().quit();
    }

}
