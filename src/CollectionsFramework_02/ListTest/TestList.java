package CollectionsFramework_02.ListTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List <Integer> list = new LinkedList<>();
        List <Integer> arrayList = new ArrayList<>();

        measureTime(list);
        measureTime(arrayList);

    }
    private static void measureTime (List <Integer> list) {
        for (int i=0;i<100000;i++)
            list.add(i);

        long start = System.currentTimeMillis();

        for (int i=0;i<100000;i++)
            list.remove(0);

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
