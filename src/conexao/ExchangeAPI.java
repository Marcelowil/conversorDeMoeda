package conexao;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeAPI {
    private String urlApi = "https://v6.exchangerate-api.com/v6/995d6d8453411632dd7ac206/latest/";

    public String converterMoeda(String moedaPrimaria, String moedaParaConverter, double valor) throws IOException {
        URL url = new URL(urlApi + moedaPrimaria);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String req_result = jsonobj.get("conversion_rates").getAsJsonObject().get(moedaParaConverter).getAsString();
        double valorConvertido = Double.parseDouble(req_result) * valor;
        return "Valor: " + valor + " [" + moedaPrimaria + "] corresponde ao valor de => " + String.format("%.2f", valorConvertido) + "[" + moedaParaConverter + "]";
    }
}
