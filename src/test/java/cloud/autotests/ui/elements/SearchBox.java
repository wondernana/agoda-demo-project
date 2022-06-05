package cloud.autotests.ui.elements;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import cloud.autotests.ui.utils.Common;

import static com.codeborne.selenide.Selenide.$;

public class SearchBox {
    private By base = By.cssSelector("[data-selenium='searchBox']");
    private SelenideElement checkInBox = $("[data-selenium='checkInBox']");
    private SelenideElement checkOutBox = $("[data-selenium='checkOutBox']");
    private SelenideElement textInput = $("[data-selenium='textInput']");
    private SelenideElement searchButton = $("[data-selenium='searchButton']");

    public SearchBox setSearchRequestForCity(String request) {
        textInput.sendKeys(request);
        new AutosuggestItem().selectCity(request);
        return this;
    }

    public SearchBox setCheckInDate(String date) {
        Common.setAttributeViaJs(checkInBox, "data-date", date);
        // click to close calendar
        checkInBox.click();
        return this;
    }

    public SearchBox setCheckOutDate(String date) {
        Common.setAttributeViaJs(checkOutBox, "data-date", date);
        // click to close calendar
        checkOutBox.doubleClick();
        return this;
    }

    public void clickSearchBtn() {
        searchButton.click();
    }
    
}
