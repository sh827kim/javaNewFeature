package com.example.java9;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImprovedHttpClient {

    void beforeJava9() {
        try {
            URL url = new URL("https://hello.kim.com/hello");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if(connection!=null) {
                connection.setConnectTimeout(10000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);

                int resCode = connection.getResponseCode();

                System.out.println("response Code : " + resCode);

                connection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void afterJava9SyncRequest() {
    }
}
