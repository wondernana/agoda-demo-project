package cloud.autotests.helpers;

import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        File videoUrl = new File(DriverUtils.getVideoUrl(sessionId));
        for (int i = 0; i < 3; i++) {
            try {
                Allure.addAttachment("Some video", "video/mp4", Files.asByteSource(videoUrl).openStream(), "mp4");
            } catch (FileNotFoundException e) {
                // waiting for video file to be processed
                Selenide.sleep(1000);
            } catch (IOException e) {
                LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", videoUrl);
                e.printStackTrace();
            }
        }
    }
}
