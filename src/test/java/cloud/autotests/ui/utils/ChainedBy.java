package cloud.autotests.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;


public class ChainedBy {

    public static By by(By... bys) {
        return new ByChained(bys);
    }

    public static By byAll(By... bys) {
        return new ByAll(bys);
    }

}
