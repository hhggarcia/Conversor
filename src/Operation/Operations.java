package Operation;

import Classes.Moneda;
import Classes.ResponsePair;
import Classes.ResponseSuccess;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Operations {
    private Gson gson;

    public Operations(){
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public ResponseSuccess ConvertResponse(String json){
        //System.out.println("Json: " + json);
        return gson.fromJson(json, ResponseSuccess.class);
    }

    public ResponsePair ExchangePair(String json){
        return gson.fromJson(json, ResponsePair.class);
    }

    public String SaveData(List<ResponsePair> lista){
        try {
            FileWriter escritura = new FileWriter("consultas.json");
            escritura.write(gson.toJson(lista));
            escritura.close();

            return "Consultas guardadas exitosamente! :)";

        }  catch (IOException | RuntimeException e) {
            return "Ha ocurrido un error guardando las consultas! :(";
        }
    }

    public String getCountry(String code){

        return switch (code) {
            case "USD" -> "Estados Unidos";
            case "AED" -> "Emiratos Árabes Unidos";
            case "AFN" -> "Afganistán";
            case "ALL" -> "Albania";
            case "AMD" -> "Armenia";
            case "ANG" -> "Antillas Neerlandesas";
            case "AOA" -> "Angola";
            case "ARS" -> "Argentina";
            case "AUD" -> "Australia";
            case "AWG" -> "Aruba";
            case "AZN" -> "Azerbaiyán";
            case "BAM" -> "Bosnia y Herzegovina";
            case "BBD" -> "Barbados";
            case "BDT" -> "Bangladés";
            case "BGN" -> "Bulgaria";
            case "BHD" -> "Baréin";
            case "BIF" -> "Burundi";
            case "BMD" -> "Bermudas";
            case "BND" -> "Brunéi";
            case "BOB" -> "Bolivia";
            case "BRL" -> "Brasil";
            case "BSD" -> "Bahamas";
            case "BTN" -> "Bután";
            case "BWP" -> "Botsuana";
            case "BYN" -> "Bielorrusia";
            case "BZD" -> "Belice";
            case "CAD" -> "Canadá";
            case "CDF" -> "República Democrática del Congo";
            case "CHF" -> "Suiza";
            case "CLP" -> "Chile";
            case "CNY" -> "China";
            case "COP" -> "Colombia";
            case "CRC" -> "Costa Rica";
            case "CUP" -> "Cuba";
            case "CVE" -> "Cabo Verde";
            case "CZK" -> "República Checa";
            case "DJF" -> "Yibuti";
            case "DKK" -> "Dinamarca";
            case "DOP" -> "República Dominicana";
            case "DZD" -> "Argelia";
            case "EGP" -> "Egipto";
            case "ERN" -> "Eritrea";
            case "ETB" -> "Etiopía";
            case "EUR" -> "Unión Europea";
            case "FJD" -> "Fiyi";
            case "FKP" -> "Islas Malvinas";
            case "FOK" -> "Islas Feroe";
            case "GBP" -> "Reino Unido";
            case "GEL" -> "Georgia";
            case "GGP" -> "Guernsey";
            case "GHS" -> "Ghana";
            case "GIP" -> "Gibraltar";
            case "GMD" -> "Gambia";
            case "GNF" -> "Guinea";
            case "GTQ" -> "Guatemala";
            case "GYD" -> "Guyana";
            case "HKD" -> "Hong Kong";
            case "HNL" -> "Honduras";
            case "HRK" -> "Croacia";
            case "HTG" -> "Haití";
            case "HUF" -> "Hungría";
            case "IDR" -> "Indonesia";
            case "ILS" -> "Israel";
            case "IMP" -> "Isla de Man";
            case "INR" -> "India";
            case "IQD" -> "Irak";
            case "IRR" -> "Irán";
            case "ISK" -> "Islandia";
            case "JEP" -> "Jersey";
            case "JMD" -> "Jamaica";
            case "JOD" -> "Jordania";
            case "JPY" -> "Japón";
            case "KES" -> "Kenia";
            case "KGS" -> "Kirguistán";
            case "KHR" -> "Camboya";
            case "KID" -> "Kiribati";
            case "KMF" -> "Comoras";
            case "KRW" -> "Corea del Sur";
            case "KWD" -> "Kuwait";
            case "KYD" -> "Islas Caimán";
            case "KZT" -> "Kazajistán";
            case "LAK" -> "Laos";
            case "LBP" -> "Líbano";
            case "LKR" -> "Sri Lanka";
            case "LRD" -> "Liberia";
            case "LSL" -> "Lesoto";
            case "LYD" -> "Libia";
            case "MAD" -> "Marruecos";
            case "MDL" -> "Moldavia";
            case "MGA" -> "Madagascar";
            case "MKD" -> "Macedonia del Norte";
            case "MMK" -> "Birmania";
            case "MNT" -> "Mongolia";
            case "MOP" -> "Macao";
            case "MRU" -> "Mauritania";
            case "MUR" -> "Mauricio";
            case "MVR" -> "Maldivas";
            case "MWK" -> "Malaui";
            case "MXN" -> "México";
            case "MYR" -> "Malasia";
            case "MZN" -> "Mozambique";
            case "NAD" -> "Namibia";
            case "NGN" -> "Nigeria";
            case "NIO" -> "Nicaragua";
            case "NOK" -> "Noruega";
            case "NPR" -> "Nepal";
            case "NZD" -> "Nueva Zelanda";
            case "OMR" -> "Omán";
            case "PAB" -> "Panamá";
            case "PEN" -> "Perú";
            case "PGK" -> "Papúa Nueva Guinea";
            case "PHP" -> "Filipinas";
            case "PKR" -> "Pakistán";
            case "PLN" -> "Polonia";
            case "PYG" -> "Paraguay";
            case "QAR" -> "Catar";
            case "RON" -> "Rumania";
            case "RSD" -> "Serbia";
            case "RUB" -> "Rusia";
            case "RWF" -> "Ruanda";
            case "SAR" -> "Arabia Saudita";
            case "SBD" -> "Islas Salomón";
            case "SCR" -> "Seychelles";
            case "SDG" -> "Sudán";
            case "SEK" -> "Suecia";
            case "SGD" -> "Singapur";
            case "SHP" -> "Santa Elena";
            case "SLE" -> "Sierra Leona";
            case "SLL" -> "Sierra Leona";
            case "SOS" -> "Somalia";
            case "SRD" -> "Surinam";
            case "SSP" -> "Sudán del Sur";
            case "STN" -> "Santo Tomé y Príncipe";
            case "SYP" -> "Siria";
            case "SZL" -> "Suazilandia";
            case "THB" -> "Tailandia";
            case "TJS" -> "Tayikistán";
            case "TMT" -> "Turkmenistán";
            case "TND" -> "Túnez";
            case "TOP" -> "Tonga";
            case "TRY" -> "Turquía";
            case "TTD" -> "Trinidad y Tobago";
            case "TVD" -> "Tuvalu";
            case "TWD" -> "Taiwán";
            case "TZS" -> "Tanzania";
            case "UAH" -> "Ucrania";
            case "UGX" -> "Uganda";
            case "UYU" -> "Uruguay";
            case "UZS" -> "Uzbekistán";
            case "VES" -> "Venezuela";
            case "VND" -> "Vietnam";
            case "VUV" -> "Vanuatu";
            case "WST" -> "Samoa";
            case "XAF" -> "África Central";
            case "XCD" -> "Caribe Oriental";
            case "XDR" -> "Derechos Especiales de Giro";
            case "XOF" -> "África Occidental";
            case "XPF" -> "Polinesia Francesa";
            case "YER" -> "Yemen";
            case "ZAR" -> "Sudáfrica";
            case "ZMW" -> "Zambia";
            case "ZWL" -> "Zimbabue";
            default -> "";
        };
    }

    public void printCountrys(List<Moneda> lista){
        for (int i = 0; i < lista.size(); i++) {
            String linea = "(" + (i+1) + ") --- "
                    + lista.get(i).getPais()
                    + " | 1$ = "
                    + lista.get(i).getValor()
                    + " "
                    + lista.get(i).getCodigoPais();
            System.out.println(linea);
        }
    }
}
