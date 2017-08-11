import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    private static final WebDriver driver = chooseDriver();

    private static WebDriver chooseDriver(){
        String browserProperty = System.getProperty("browser", "chrome");
        switch (browserProperty) {
            case "chrome":
                return initChromeDriver();
            case "ie":
                return initIEDriver();
            default:
                return initChromeDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(capabilities);
    }

    private static WebDriver initIEDriver(){
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer32.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        return new InternetExplorerDriver(capabilities);
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
