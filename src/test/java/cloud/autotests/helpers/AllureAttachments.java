package cloud.autotests.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class AllureAttachments {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllureAttachments.class);

    @Attachment(value = "{attachName}", type = "text/plain")
    private static String addMessage(String attachName, String text) {
        return text;
    }

    public static void addBrowserConsoleLogs() {
        addMessage("Browser console logs", DriverUtils.getConsoleLogs());
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return DriverUtils.getScreenshotAsBytes();
    }

    @Attachment(value = "Page source", type = "text/html")
    public static byte[] addPageSource() {
        return DriverUtils.getPageSourceAsBytes();
    }

    public static void addVideo(String sessionId) {
        URL videoUrl = DriverUtils.getVideoUrl(sessionId);
        for (int i = 0; i < 3; i++) {
            if (videoUrl != null) {
                try {
                    Allure.addAttachment("Some video", "video/mp4", videoUrl.openStream(), "mp4");
                    break;
                } catch (FileNotFoundException e) {
                    // waiting for video file to be processed
                    LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant find allure video, {}", videoUrl);
                    Selenide.sleep(1000);
                } catch (IOException e) {
                    LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", videoUrl);
                    e.printStackTrace();
                }
            }
        }
    }
}
