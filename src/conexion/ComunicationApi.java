package conexion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ComunicationApi {

    private String BASE;
    private String KEY;

    public ComunicationApi(){
        this.BASE = "https://v6.exchangerate-api.com/v6/";
        this.KEY = "f0bd771393acc599b26aa998";
    }

    public String getExchangeRate() throws IOException, InterruptedException {

        String direccion = this.getBASE()+this.getKEY() + "/latest/USD";
        //System.out.println("Direccion: "+ direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String Conversion(String countryBase,
                             String countryTarget,
                             double amount) throws IOException, InterruptedException {
        String direccion = this.getBASE() +
                this.getKEY() +
                "/pair/" +
                countryBase + "/" +
                countryTarget + "/" +
                amount;

        //System.out.println("Direccion: "+ direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getBASE() {
        return BASE;
    }

    public String getKEY() {
        return KEY;
    }
}
