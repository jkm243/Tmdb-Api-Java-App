package org.example;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class App
{
    public static void main( String[] args ) throws UnirestException, UnsupportedEncodingException {
        //System.out.println("My app");
        // Host url
//
        String host = "https://api.themoviedb.org/3/movie/550";
        String charset = "UTF-8";

        // Headers for a request
        String x_tmdbapi_host = "api.themoviedb.org/3/movie/550";
        String x_tmdbapi_key = "ce3a9919c08c2205f8f4f1a521bf4f68";//Type here your key

        // Params
        String s = "api_key=";
        // Format query for preventing encoding problems
        String query = String.format("s=%s",
                URLEncoder.encode(s, charset));

        HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
                .header("x-rapidapi-host", x_tmdbapi_host)
                .header("x-rapidapi-key", x_tmdbapi_key)
                .asJson();
        System.out.println(response.getStatus());
        System.out.println(response.getHeaders().get("Content-Type"));
    }
}
