package ru.sberbank.autotests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        return new ChromeDriver(capabilities);
    }

    private static WebDriver initIEDriver(){
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer32.exe");
        return new InternetExplorerDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
