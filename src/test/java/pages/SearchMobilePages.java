package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.DriverConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchMobilePages {
    DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());
    private SelenideElement
            clickSearchWiki = $(accessibilityId("Search Wikipedia")),
            searchWikiTable = $(id("org.wikipedia.alpha:id/search_src_text")),
            errorPage = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));
    private ElementsCollection
            resultListPage = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Нажатие на поисковую строку")
    public SearchMobilePages clickSearchTable() {
        clickSearchWiki.click();
        return this;
    }

    @Step("Ввод необходимого значения в поисковую строку")
    public SearchMobilePages appiumSearchWiki() {
        searchWikiTable.sendKeys("Appium");
        return this;
    }

    @Step("Проверка, что значений поиска больше нуля")
    public SearchMobilePages checkResultsAppium() {
        resultListPage.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Ввод необходимого значения в поисковую строку")
    public SearchMobilePages setSearchData() {
        searchWikiTable.sendKeys(driverConfig.searchData());
        return this;
    }

    @Step("Клик на первый результат поиска")
    public SearchMobilePages clickFirstResult() {
        resultListPage.first().click();
        return this;
    }

    @Step("Проверка ошибки An error occurred")
    public SearchMobilePages checkOpenPageError() {
        errorPage.shouldHave(Condition.text("An error occurred"));
        return this;

    }
}
