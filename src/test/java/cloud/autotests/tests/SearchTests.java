package cloud.autotests.tests;

import cloud.autotests.tests.steps.CommonSteps;
import cloud.autotests.tests.steps.SearchSteps;
import cloud.autotests.ui.pages.MainPage;
import cloud.autotests.ui.pages.SearchResultsPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static cloud.autotests.ui.utils.Common.*;
import static cloud.autotests.ui.utils.Popup.closePopup;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Hotel search in city")
public class SearchTests extends TestBase {

    private final CommonSteps commonSteps = new CommonSteps();
    private final SearchSteps searchSteps = new SearchSteps();
    private final String datePattern = "yyyy-MM-dd";
    private final String city = "Bangkok";

    @Test
    @Tag("positive")
    @DisplayName("Verify successful search with check in date = today, check out date = tomorrow")
    void searchCheckingInToday() {
        String checkInDate = getFormattedDate(getCurrentDate(), datePattern);
        String checkOutDate = getFormattedDate(getRelativeDate(1), datePattern);

        commonSteps
                .openMainPage()
                .closePopupIfPresent();

        searchSteps
                .fillSearchRequestWith(city, checkInDate, checkOutDate)
                .verifySearchResultsNotEmpty();

    }

    @Test
    @Tag("positive")
    @DisplayName("Verify search results are in requested city")
    void checkHotelItem() {
        String checkInDate = getFormattedDate(getRelativeDate(1), datePattern);
        String checkOutDate = getFormattedDate(getRelativeDate(7), datePattern);

        commonSteps
                .openMainPage()
                .closePopupIfPresent();

        searchSteps
                .fillSearchRequestWith(city, checkInDate, checkOutDate)
                .verifySearchResultsNotEmpty()
                .verifySearchResultsAddressContain(city);

    }



    
}
