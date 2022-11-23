package Regexp_04.Lesson_30;

public class Test {
    public static void main(String[] args) {
        /*  РЕГУЛЯРНЫЕ ВЫРАЖЕНИЯ
            \\d - одна цифра
            \\w - одна буква
            \\w = [a-zA-Z]

            + - один или более
            * - 0 или более
            ? - символ до него может быть, а может не быть. 0 или 1 символов до (до\\)

            (x|y|z) - одна строка из множества строк

            [abc] = (a|b|c)
            [a-zA-z] - все английские буквы
            [0-9] - все возможные цифры = \\d
            [^abc] - НЕ (отрицание) - мы хотим все символы кроме [abc]

            . - любой символ

            {2} - 2 символа до (\\d{2})
            {2, } - от 2-ух до бесконечности символов (\\d{2,})
            {2,4} - от 2-ух до 4-ех символов (\\d{2,4})

         */

        String a = "-11";
        String b = "45";
        String c = "+23";

//        System.out.println(a.matches("(-|\\+)?\\d*"));
//        System.out.println(b.matches("(-|\\+)?\\d*"));
//        System.out.println(c.matches("(-|\\+)?\\d*"));

        String d = "fasdS123123123";
//        System.out.println(d.matches("[a-zA-Z31]+\\d+"));

        String e = "hello";
//        System.out.println(e.matches("[^abc]*"));


        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        String url3 = "Hello there!";
//        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
//        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));
//        System.out.println(url3.matches("http://www\\..+\\.(com|ru)"));

        String f = "1223";
        System.out.println(f.matches("\\d{2,}"));

    }
}
