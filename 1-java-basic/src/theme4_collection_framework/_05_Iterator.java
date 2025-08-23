package theme4_collection_framework;

import java.util.*;

public class _05_Iterator {
    public static void main(String[] args) {
        //  polymorphism
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("(unknown)");
        list.add("BBB");
        list.add("(unknown)");
        list.add("CCC");
        list.add("(unknown)");
        list.add("DDD");
        list.add("(unknown)");
        list.add("EEE");

        for(String s : list){
            System.out.println(s);
        }
        System.out.println("==========================");

        Iterator<String> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
        iterator =  list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
        iterator =  list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.equals("(unknown)")) {
                iterator.remove();
            }
        }
        System.out.println(list);
        System.out.println("==========================");
        Set<String> set = new HashSet<>();
        set.add("AAA");
        set.add("AAA");
        set.add("AAC");
        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        System.out.println("==========================");
        Map<String, Integer> map = new HashMap<>();
        map.put("AAA",1);
        map.put("BBB",2);
        map.put("CCC",3);
        map.put("DDD",4);
        Iterator<Map.Entry<String, Integer>> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}
