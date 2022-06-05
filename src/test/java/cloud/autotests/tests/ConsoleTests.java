package cloud.autotests.tests;

import cloud.autotests.tests.steps.CommonSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleTests {
    private final CommonSteps commonSteps = new CommonSteps();

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    public void consoleShouldNotHaveErrorsTest() {
        commonSteps
                .openMainPage()
                .checkLogsForErrorsWithType("SEVERE");
    }
}