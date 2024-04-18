package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchMobilePages;

import static io.qameta.allure.Allure.step;

public class SearchMobileTest extends TestBase {
    SearchMobilePages mobilePages = new SearchMobilePages();

    @Owner("iStarzG")
    @DisplayName("Checking the output of results")
    @Test
    void successfulSearchTest() {
        step("Type search", () -> {
            mobilePages.clickSkipButton()
                    .clickSearchTable()
                    .appiumSearchWiki();
        });
        step("Verify content found", () ->
                mobilePages.checkResultsAppium());
    }

    @Owner("iStarzG")
    @DisplayName("Checking that a page opens with the required content")
    @Test
    void searchEnteredValue() {
        step("Type search", () -> {
            mobilePages.clickSkipButton()
                    .clickSearchTable()
                    .setSearchData()
                    .clickFirstResult();
        });
        step("Verify content", () ->
                mobilePages.checkResultPage());
    }
}

