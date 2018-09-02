package api.yandex.translate;

import api.yandex.translate.impl.YandexTranslateImpl;

public class Start {
    public static void main(String[] args) {
        YandexTranslate translate = new YandexTranslateImpl();
        translate.translateEnRu("any language");
    }
}
