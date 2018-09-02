
import api.yandex.translate.YandexTranslate;
import api.yandex.translate.impl.YandexTranslateImpl;
import api.yandex.translate.model.JSONResponse;
import tools.JsonTools;

public class Start {
    public static void main(String[] args) {
        JsonTools jsonTools = new JsonTools();
        YandexTranslate translate = new YandexTranslateImpl();
        JSONResponse response = jsonTools.jsonParseYndexResponse(translate.translateEnRu("language"));
        System.out.println(response.getText());

    }
}
