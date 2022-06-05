package cloud.autotests.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "password",
        "authType",
        "username"
})
@Builder
public class Credentials {
    @JsonProperty("password")
    public String password;
    @JsonProperty("authType")
    public String authType;
    @JsonProperty("username")
    public String username;
}
