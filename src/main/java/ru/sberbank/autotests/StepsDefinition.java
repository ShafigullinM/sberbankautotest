package ru.sberbank.autotests;

import org.junit.Assert;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;


public class StepsDefinition {

    final MainPage mainpage = new MainPage();

    @Дано("^главная страница открыта$")
    public void mainPageisOpened() {
        Assert.assertTrue("Главная страница не загружена", "«Сбербанк» - Частным клиентам".equals(mainpage.getPageTitle()));
    }

    @Когда("^кликнута ссылка \"Выберете регион\"$")
    public void clickOnChooseRegion() {
        mainpage.chooseRegionClick();
    }

    @Когда("^введен регион \"([^\"]*)\" в поле поиска$")
    public void enterRegionnameOnInput(String value) {
        mainpage.searchRegionInputEnter(value);
    }

    @Когда("^кликнут регион \"([^\"]*)\" в всплывающем списке$")
    public void clickRegionNameOnPopUp(String value) {
        mainpage.clickAutoCompleteElementByRegion(value);
    }

    @Тогда("^выбранный регион на главной странице \"([^\"]*)\"$")
    public void chechRegionOnNewPage(String value) {
        Assert.assertTrue("Регион имеет неправильное значение", mainpage.getPageRegion().equals(value));
    }

    @Когда("проскролили к футеру страницы")
    public void moveToFooterOfPage() {
        mainpage.moveToFooter();
    }

    @Тогда("^иконки социальных сетей имеют ссылку на \"([^\"]*)\"$")
    public void checkSocialLinkHref(String href) {
        Assert.assertTrue("Нет ссылки на социальную сеть - " + href, mainpage.checkSocialLinksContainsURL(href));
    }

}
