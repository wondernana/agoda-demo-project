package cloud.autotests.tests.steps;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static cloud.autotests.ui.utils.Popup.closePopup;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    @Step("Open main page")
    public CommonSteps openMainPage() {
       open("");
        return this;
    }

    @Step("Close popup if present")
    public CommonSteps closePopupIfPresent() {
        closePopup();
        return this;
    }

    @Step("Console logs should not contain text {errType}")
    public CommonSteps checkLogsForErrorsWithType(String errType) {
        String consoleLogs = DriverUtils.getConsoleLogs();
        assertThat(consoleLogs).doesNotContain(errType);
        return this;
    }

    @Step("Set cookie {name} = {cookie} to to browser")
    public CommonSteps setCookieToBrowser(String name, String cookie) {
        getWebDriver().manage().addCookie(
                new Cookie("token", cookie));
        return this;
    }

    @Step("Refresh page")
    public CommonSteps refreshPage() {
        Selenide.refresh();
        return this;
    }




}
