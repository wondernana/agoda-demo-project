package cloud.autotests.tests;

import cloud.autotests.config.App;
import cloud.autotests.tests.steps.CommonSteps;
import cloud.autotests.tests.steps.LoginSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Story("Login tests")
@Feature("Sign in with email")
public class LoginTests extends TestBase {
    // for now broken because of captcha
    private final LoginSteps loginSteps = new LoginSteps();
    private final CommonSteps commonSteps = new CommonSteps();

    @Test
    @Tag("positive")
    @DisplayName("Successful login with email via UI")
    void checkLoginViaEmailUI() {
        loginSteps
                .openLoginPage()
                .loginWithEmail(App.config.userEmail(), App.config.userPassword())
                .verifySuccessfulLoginAs(App.config.userLogin());
    }

    @Test
    @Tag("positive")
    @DisplayName("Successful authorization with email via API + UI")
    void checkLoginViaEmailAPI() {
        String authorizationCookie = loginSteps.getAuthCookie();
        //open main page, because cookie can be set when site is opened
         commonSteps
                 .openMainPage()
                 .setCookieToBrowser("token", authorizationCookie)
                 .refreshPage();
         loginSteps.verifySuccessfulLoginAs(App.config.userLogin());
    }
}
