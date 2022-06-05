package cloud.autotests.ui.elements;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import lombok.Getter;

import static cloud.autotests.ui.utils.ChainedBy.by;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Header {
    private By base = By.cssSelector("[data-selenium='page-header']");
    private SelenideElement signInBtn = $(by(base, By.cssSelector("sign-in-btn")));
    private SelenideElement loginText = $(by(base, By.cssSelector("[data-selenium='login-text']")));

}
