package Classes;

import com.google.gson.annotations.SerializedName;

public class ResponsePair {

    @SerializedName("result")
    private String result;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("target_code")
    private String targetCode;

    @SerializedName("conversion_rate")
    private Double conversionRate;

    @SerializedName("conversion_result")
    private Double conversionResult;

    @Override
    public String toString() {
        return "ResponsePair{" +
                "result='" + result + '\'' +
                ", baseCode='" + baseCode + '\'' +
                ", targetCode='" + targetCode + '\'' +
                ", conversionRate=" + conversionRate +
                ", conversionResult=" + conversionResult +
                '}';
    }

    public void printPair(){
        String linea = "| Resultado: " +
                this.result + " -- " +
                " De: " + this.baseCode + " -- " +
                " Para: " + this.targetCode + " -- " +
                " Resultado: " + this.conversionResult + " | ";
        System.out.println(linea);
    }

    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public Double getConversionResult() {
        return conversionResult;
    }
}
