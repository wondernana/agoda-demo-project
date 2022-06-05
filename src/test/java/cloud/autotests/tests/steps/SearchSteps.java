package cloud.autotests.tests.steps;

import cloud.autotests.ui.pages.MainPage;
import cloud.autotests.ui.pages.SearchResultsPage;
import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps {

    @Step("Search for a hotel in {city} from {checkInDate} to {checkOutDate}")
    public SearchSteps fillSearchRequestWith(String city, String checkInDate, String checkOutDate) {
        new MainPage()
                .getSearchBox()
                .setSearchRequestForCity(city)
                .setCheckInDate(checkInDate)
                .setCheckOutDate(checkOutDate)
                .clickSearchBtn();
        return this;
    }

    @Step("Verify search results are not empty")
    public SearchSteps verifySearchResultsNotEmpty() {
        new SearchResultsPage()
                .assertResultsNotEmpty();
        return this;
    }

    @Step("Verify search results are in {city}")
    public SearchSteps verifySearchResultsAddressContain(String city){
        assertThat(
                new SearchResultsPage()
                        .getAllResults()
                                .stream()
                                .allMatch(result -> result.getAddress().contains(city)))
            .isTrue();
        return this;
    }

}
