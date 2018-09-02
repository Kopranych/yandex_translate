package api.yandex.translate.impl;

import api.yandex.translate.YandexTranslate;
import api.yandex.translate.model.JSONResponse;
import tools.JsonTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class YandexTranslateImpl implements YandexTranslate {

    private static final String API_KEY = "trnsl.1.1.20180901T181627Z.a3c4d72434150a05.f4ac4dca859bc2ff3889501562e898b6eec45d88";
    private static final String HOST = "https://translate.yandex.net/api/v1.5/tr.json/translate";

    public String translateEnRu(String text) {
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String request = HOST + "?key=" + API_KEY + "&text=" + text  + "&lang=en-ru";
        String response = null;
        HttpURLConnection connection = null;
        StringBuilder strBuilder = new StringBuilder();
        try {
            connection = (HttpURLConnection) new URL(request).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String tmp;
                while ((tmp = reader.readLine()) != null) {
                    strBuilder.append(tmp);
                }
                JsonTools jTools = new JsonTools();
                JSONResponse jsonResponse = jTools.jsonParseYndexResponse(strBuilder.toString());
                response = jsonResponse.getText().get(0);
            } else {
                return String.valueOf(connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return response;
    }

    public String translateAny(String text) {
        return null;
    }
}
