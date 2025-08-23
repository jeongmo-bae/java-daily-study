package theme4_collection_framework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class _03_HashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("AA");
        set.add("AB");
        set.add("AC");
        set.add("ACA");
        set.add("ACB");
        set.add("ACB");
        System.out.println(set);

        for(String s : set){
            System.out.println(s);
        }
        if (set.contains("AA")){
            set.remove("AA");
            System.out.println(set);
        }
        LinkedHashSet<Integer> intSet  =  new LinkedHashSet<>();
        intSet.add(1);
        intSet.add(13);
        intSet.add(12);

    }
}
