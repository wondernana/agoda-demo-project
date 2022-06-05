package cloud.autotests.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("responseCode")
    public Integer responseCode;
    @JsonProperty("code")
    public Integer code;
    @JsonProperty("message")
    public String message;
}
