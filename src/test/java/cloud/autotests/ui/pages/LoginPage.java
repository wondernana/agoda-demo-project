package cloud.autotests.ui.pages;

import cloud.autotests.ui.elements.Header;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {
    private Header header;
    private SelenideElement loginIFrame = $(By.cssSelector("iframe[data-cy='ul-app-frame']"));
    private SelenideElement emailField = $(By.cssSelector("#email"));
    private SelenideElement passwordField = $(By.cssSelector("#password"));
    private SelenideElement submitBtn = $(By.cssSelector("[data-element-name='universal-login-signin-email-button']"));

    public LoginPage(){
        header = new Header();
    }

    public LoginPage switchToLoginFrame(){
        switchTo().frame(loginIFrame);
        return this;
    }

    public LoginPage fillEmailWith(String userEmail){
        emailField
                .shouldBe(visible)
                .setValue(userEmail);
        return this;
    }

    public LoginPage fillPasswordWith(String userPassword){
        passwordField
                .shouldBe(visible)
                .setValue(userPassword);
        return this;
    }

    public void submitLoginForm(){
        submitBtn.click();
    }

}
