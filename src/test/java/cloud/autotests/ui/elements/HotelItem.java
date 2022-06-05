package cloud.autotests.ui.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static cloud.autotests.ui.utils.ChainedBy.by;
import static com.codeborne.selenide.Selenide.$;

public class HotelItem {
    private By base;
    private By title;
    private By address;

    public HotelItem(String name) {
        this.base = By.xpath(String.format(".//h3[contains(., '%s')]/ancestor::*[@data-selenium='hotel-item']", name));
        this.title = by(base, By.cssSelector("[data-selenium='hotel-name']"));
        this.address = by(base, By.cssSelector("[data-selenium='area-city']"));
    }

    public HotelItem() {
        this("");
    }

    public HotelItem should(Condition condition) {
        $(base).should(condition);
        return this;
    }

    public String getTitle() {
        return $(title).text().trim();
    }

    public String getAddress() {
        return $(address).text().trim();
    }

}
