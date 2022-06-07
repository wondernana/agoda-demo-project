package cloud.autotests.helpers;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static cloud.autotests.helpers.DriverUtils.getSessionId;
import static cloud.autotests.helpers.URLUtils.getVideoUrl;

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

//    @Attachment(value = "Video file", type = "video/mp4", fileExtension = ".mp4")
//    public static byte[] addVideo(String sessionId) {
//        URL videoUrl = URLUtils.getVideoUrl(sessionId);
//        return URLUtils.fetchBytesWithRetry(videoUrl, 3);
//    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo(String sessionId) {
        URL videoUrl = getVideoUrl(sessionId);
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl(getSessionId())
                + "' type='video/mp4'></video></body></html>";
    }
}
