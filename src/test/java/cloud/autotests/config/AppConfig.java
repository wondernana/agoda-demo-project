package cloud.autotests.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:config/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();
    String apiUrl();
    String userEmail();
    String userLogin();
    String userPassword();

}
