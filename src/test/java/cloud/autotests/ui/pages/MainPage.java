package cloud.autotests.ui.pages;

import cloud.autotests.ui.elements.Header;
import cloud.autotests.ui.elements.SearchBox;
import lombok.Getter;

import static com.codeborne.selenide.Condition.*;

@Getter
public class MainPage {
    private Header header;
    private SearchBox searchBox;

    public MainPage() {
        header = new Header();
        searchBox = new SearchBox();
    }

    public MainPage verifyLoggedInAs(String login) {
        header.getLoginText().shouldHave(text(login));
        return this;
    }

    public MainPage verifySignInBtnNotVisible() {
        header.getSignInBtn().shouldNotBe(visible);
        return this;
    }
}
