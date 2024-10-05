package Classes;

import com.google.gson.annotations.SerializedName;

public class ResponseError {
    @SerializedName("result")
    private String result;
    @SerializedName("error-type")
    private String errorType;

    public String getResult() {
        return result;
    }

    public String getErrorType() {
        return errorType;
    }
}
