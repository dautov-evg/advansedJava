package Regexp_04.Lesson_31;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String a = "Hello1322154there132135651hey31351813quqewre";
        String[] words = a.split("\\d+");
        //System.out.println(Arrays.toString(words));

        String b = "Hello there here";
        String modifyString = b.replace(" ", ".");
        //System.out.println(modifyString);

        String c = "Hello135651there6151618here";
        String modifyStringAll = c.replaceAll("\\d+", " ");
        System.out.println(modifyStringAll);
        String modify = c.replaceFirst("\\d+", " ");
        System.out.println(modify);
    }
}
