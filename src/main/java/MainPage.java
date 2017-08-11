import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='kit-link kit-link_color_black region-list__toggler']")
    private WebElement regionPageLink;

    @FindBy(xpath = "//a[@class='kit-link kit-link_color_black region-list__toggler']")
    private WebElement regionPopupLink;

    @FindBy(xpath = "//div[@class='region-search-box']//input[@class='kit-input__control']")
    private WebElement regionSearchInput;

    @FindBy(xpath = "//div[@class='kit-autocomplete-input__option']")
    private List<WebElement> autocompleteElements;

    @FindBy(xpath = "//div[@class='footer-info']")
    private WebElement footerPage;

    @FindBy(xpath = "//ul[@class='social__list']//a")
    private List<WebElement> sociallinkElements;

    public MainPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageRegion() {
        return regionPageLink.getText();
    }

    public void chooseRegionClick() {
        regionPopupLink.click();
    }

    public void searchRegionInputEnter(String region) {
        regionSearchInput.sendKeys(region);
    }

    private List<WebElement> getRegionAutoCompleteElements() {
        return autocompleteElements;
    }

    public void clickAutoCompleteElementByRegion(String region) {
        for (int i = 0; i < autocompleteElements.size(); i++) {
            if (region.equals(autocompleteElements.get(i).getText())) {
                autocompleteElements.get(i).click();
                return;
            }
        }
        Assert.fail("Регион под именем \"" + region + "\" не найден");
    }

    public void moveToFooter() {
        Actions actions = new Actions(driver);
        actions.moveToElement(footerPage);
        actions.perform();
    }

    public boolean checkSocialLinksContainsURL(String href) {
        for (int i = 0; i < sociallinkElements.size(); i++) {
            if (sociallinkElements.get(i).getAttribute("href").contains(href)) {
                return true;
            }
        }
        return false;
    }

}
