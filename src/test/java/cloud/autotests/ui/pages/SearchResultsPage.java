package cloud.autotests.ui.pages;

import cloud.autotests.ui.elements.Header;
import cloud.autotests.ui.elements.HotelItem;
import cloud.autotests.ui.elements.SearchBox;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static cloud.autotests.ui.utils.ChainedBy.by;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private Header header;
    private SearchBox searchBox;
    private By resultsContainer = By.cssSelector(".hotel-list-container");

    public SearchResultsPage() {
        header = new Header();
        searchBox = new SearchBox();
    }

    public void assertResultsNotEmpty() {
        $$(by(resultsContainer, By.cssSelector("[data-selenium='hotel-item']")))
                .shouldHave(sizeGreaterThanOrEqual(1));
    }

    public HotelItem findResult(String name) {
        return new HotelItem(name).should(visible);
    }

    public List<HotelItem> getAllResults() {
        List<HotelItem> hotelItems = new ArrayList<>();
        $$(by(resultsContainer, By.cssSelector("[data-selenium='hotel-item']")))
                .forEach(item -> hotelItems.add(new HotelItem()));
        return hotelItems;
    }


}
