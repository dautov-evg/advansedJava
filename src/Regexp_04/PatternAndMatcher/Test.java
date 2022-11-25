package Regexp_04.PatternAndMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = " Hello, Guys! I sand you my email joe@gmail.com so we can \n" +
                "keep in touch. Thanks, Joe! That's cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find()) { // пока есть соответствия
            System.out.println(matcher.group()); // получение того, что нашли
            //System.out.println(matcher.group(1)); // получение нужной части по группам, (круглые скобки) - имя почты
            //System.out.println(matcher.group(2)); // получение нужной части по группам, (круглые скобки) - сервис почты
            //System.out.println(matcher.group(3)); // получение нужной части по группам, (круглые скобки) - домен ру/ком
        }
    }
}
