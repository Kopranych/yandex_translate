package api.yandex.translate.impl;

import api.yandex.translate.YandexTranslate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YandexTranslateImpl implements YandexTranslate {

    private static final String API_KEY = "trnsl.1.1.20180901T181627Z.a3c4d72434150a05.f4ac4dca859bc2ff3889501562e898b6eec45d88";
    private static final String HOST = "https://translate.yandex.net/api/v1.5/tr.json/translate";

    public String translateEnRu(String text) {
        String request = HOST + "?key=" + API_KEY + "&text=" + text  + "&lang=en-ru";
        HttpURLConnection connection = null;
        StringBuilder strBuilder = new StringBuilder();
        try {
            connection = (HttpURLConnection) new URL(request).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(200);
            connection.setReadTimeout(200);
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String tmp;
                while ((tmp = reader.readLine()) != null) {
                    strBuilder.append(tmp);
                }

            } else {
                return String.valueOf(connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return strBuilder.toString();
    }

    public String translateAny(String text) {
        return null;
    }
}
