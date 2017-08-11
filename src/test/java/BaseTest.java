import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import ru.sberbank.autotests.AbstractPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features")
public class BaseTest {

    @BeforeClass
    public static void openMainPage() {
        ResourceBundle resources = ResourceBundle.getBundle("config");
        AbstractPage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.getDriver().manage().window().maximize();
        AbstractPage.getDriver().navigate().to(resources.getString("app.url"));
    }

    @AfterClass
    public static void quit() {
        AbstractPage.getDriver().quit();
    }

}
