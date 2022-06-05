package cloud.autotests.tests.steps;

import cloud.autotests.api.Credentials;
import cloud.autotests.api.LoginRequest;
import cloud.autotests.api.LoginResponse;
import cloud.autotests.config.App;
import cloud.autotests.helpers.AllureRestAssuredFilter;
import cloud.autotests.ui.pages.LoginPage;
import cloud.autotests.ui.pages.MainPage;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    @Step("Open login page")
    public LoginSteps openLoginPage() {
        open("/account/signin.html");
        return this;
    }

    @Step("Login with {userEmail}/{userPassword}")
    public LoginSteps loginWithEmail(String userEmail, String userPassword){
        new LoginPage()
                .switchToLoginFrame()
                .fillEmailWith(userEmail)
                .fillPasswordWith(userPassword)
                .submitLoginForm();
        return this;
    }

    @Step("Verify successful authorization as {userLogin}")
    public LoginSteps verifySuccessfulLoginAs(String userLogin) {
        new MainPage()
                .verifyLoggedInAs(userLogin)
                .verifySignInBtnNotVisible();
        return this;
    }

    @Step("Get cookie by api and set it to browser")
    public String getAuthCookie() {

        Response response = given()
                .filter(AllureRestAssuredFilter.withCustomTemplates())
                .contentType(ContentType.JSON)
                .body(buildLoginRequest())
                .when()
                .post("/ul/api/v1/signin")
                .then()
                .log()
                .everything()
                .statusCode(200)
                .extract()
                .response();

        LoginResponse loginResponse = response.getBody().as(LoginResponse.class);
        assertEquals(true, loginResponse.success);
        assertEquals("Authenticated", loginResponse.message);
        return response.cookie("ul.token");
    }

    private LoginRequest buildLoginRequest() {
        return LoginRequest.builder()
                .credentials(
                        Credentials.builder()
                                .password(App.config.userPassword())
                                .authType("email")
                                .username(App.config.userEmail())
                                .build())
                .captchaEnabled(true)
                .build();
    }

}
