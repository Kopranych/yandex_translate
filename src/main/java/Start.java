import api.yandex.translate.YandexTranslate;
import api.yandex.translate.impl.YandexTranslateImpl;

import java.util.Scanner;


public class Start {
    public static void main(String[] args) {

        YandexTranslate translate = new YandexTranslateImpl();
        System.out.println("Введите слово которое необходимо перевести,\n" +
                "для завершения программы введите \"stop\" ");
        String text = new String();
        String translateText;
        while(!text.equals("stop")){
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
            translateText = translate.translateEnRu(text);
            System.out.println(translateText);
        }

    }

}
