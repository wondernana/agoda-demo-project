package cloud.autotests.helpers;

import cloud.autotests.config.Project;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(AllureAttachments.class);

    public static byte[] fetchBytesWithRetry(URL url, int maxTries) {
        LOGGER.debug("Fetching file: {}", url);
        for (int i = 0; i < maxTries; i++) {
            Response response = RestAssured.get(url);
            if (response.getStatusCode() == HttpStatus.SC_OK) {
                return response.asByteArray();
            }
            LOGGER.debug("Retrying fetching file: {}", url);
            Selenide.sleep(2000);
        }
        return null;
    }

    public static URL getVideoUrl(String sessionId) {
        String videoUrl = Project.config.videoStorage() + sessionId + ".mp4";
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            DriverUtils.LOGGER.warn("Malformed video url, {}", videoUrl);
            e.printStackTrace();
        }
        return null;
    }
}
