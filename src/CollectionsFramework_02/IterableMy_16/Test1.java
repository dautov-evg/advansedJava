package CollectionsFramework_02.IterableMy_16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        Iterator<Integer> iterator = list.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (idx==1) {
                iterator.remove();
            }
            idx++;
        }
        System.out.println(list);

//        for (int x : list) {
//            System.out.println(x);
//        }


    }
}
