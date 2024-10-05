package Classes;

import Operation.Operations;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResponseSuccess {
    @SerializedName("result")
    private String result;
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRatesMap;

    public List<Moneda> getConversionRates(){
        Operations op = new Operations();
        List<Moneda> conversionRates = new ArrayList<>();
        for (Map.Entry<String, Double> entry : conversionRatesMap.entrySet()) {
            conversionRates.add(new Moneda(entry.getKey(), entry.getValue(), op.getCountry(entry.getKey())));
        }

        return conversionRates;
    }
}
