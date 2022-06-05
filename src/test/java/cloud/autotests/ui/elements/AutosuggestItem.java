package cloud.autotests.ui.elements;

import org.openqa.selenium.By;

import static cloud.autotests.ui.utils.ChainedBy.by;
import static com.codeborne.selenide.Selenide.$;

public class AutosuggestItem {
    private By base;

    public AutosuggestItem() {
        this.base = By.cssSelector("[data-selenium='autosuggest-item']");
    }

    public void selectCity(String name) {
        $(by(base, By.xpath(String.format(".//li[contains(., '%s')]/following-sibling::*[contains(., 'City')]", name))))
                .click();
    }


}
