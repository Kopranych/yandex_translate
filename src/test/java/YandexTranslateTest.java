import api.yandex.translate.YandexTranslate;
import api.yandex.translate.impl.YandexTranslateImpl;
import org.junit.Assert;
import org.junit.Test;

public class YandexTranslateTest {
    @Test
    public void testTranslate(){
        YandexTranslate yandexTranslate = new YandexTranslateImpl();
        String text = yandexTranslate.translateEnRu("api yandex translate is a good service");
        Assert.assertEquals("API Яндекс перевод хороший сервис", text);
    }
}
