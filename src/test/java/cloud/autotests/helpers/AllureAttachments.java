package cloud.autotests.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

    @Attachment(value = "VideoFile", type = "video/mp4", fileExtension = ".mp4")
    public static byte[] addVideo(String sessionId) {
        URL videoUrl = DriverUtils.getVideoUrl(sessionId);
        return getFileAsBytes(videoUrl);
    }

    private static byte[] getFileAsBytes(URL fileUrl) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        for (int i = 0; i < 3; i++) {
            try (InputStream stream = fileUrl.openStream()) {
                byte[] chunk = new byte[4096];
                int bytesRead;

                while ((bytesRead = stream.read(chunk)) > 0) {
                    outputStream.write(chunk, 0, bytesRead);
                }
                break;
            } catch (FileNotFoundException e) {
                // waiting for video file to be processed
                LOGGER.warn("[ALLURE VIDEO NOT FOUND] Cant find allure video, {}", fileUrl);
                e.printStackTrace();
                Selenide.sleep(1000);
            } catch (IOException e) {
                LOGGER.warn("[ALLURE VIDEO ATTACHMENT ERROR] Cant attach allure video, {}", fileUrl);
                e.printStackTrace();
                return null;
            }
        } return outputStream.toByteArray();
    }
}
