package cloud.autotests.ui.utils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

import com.codeborne.selenide.SelenideElement;

public class Common {

    public static void setAttributeViaJs(SelenideElement element, String attName, String attValue) {
        executeJavaScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
                element, attName, attValue);
    }

    public static String dateToString(LocalDateTime localDateTime, String format) {
        return  localDateTime
                .format(new DateTimeFormatterBuilder()
                        .appendPattern(format)
                        .toFormatter());
    }

    public static String getFormattedDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date getRelativeDate(int daysToAdd) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);
        return calendar.getTime();
    }


}
