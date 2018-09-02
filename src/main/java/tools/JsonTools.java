package tools;

import api.yandex.translate.model.JSONResponse;
import com.google.gson.Gson;

public class JsonTools {

    public JSONResponse jsonParseYndexResponse(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, JSONResponse.class);
    }
}
