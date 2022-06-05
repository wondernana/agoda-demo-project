package cloud.autotests.ui.utils;

import static com.codeborne.selenide.Selenide.$;

public class Popup {
    public static void closePopup() {
        if($(".ab-page-blocker").exists()) {
            $(".ab-close-button").click();
        }
    }
}
