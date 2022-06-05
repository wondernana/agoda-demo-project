package cloud.autotests.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "credentials",
        "captchaEnabled"
})
@Builder
public class LoginRequest {
    @JsonProperty("credentials")
    public Credentials credentials;
    @JsonProperty("captchaEnabled")
    public Boolean captchaEnabled;
}
