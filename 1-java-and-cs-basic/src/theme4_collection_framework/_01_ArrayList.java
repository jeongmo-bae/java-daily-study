package theme4_collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class _01_ArrayList {
    public static void main(String[] args) {
        int[] iList = new int[3];
        iList[0] = 1;
        iList[1] = 2;
        iList[2] = 3;
        System.out.println(Arrays.toString(iList));
        System.out.println("=========================");
        // ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("배정모");
        arrayList.add("신주연");
        arrayList.add("유재석");
        arrayList.set(0,"배정모모");
        arrayList.add(0,"qowjdah");
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
        String first = arrayList.remove(0);
        System.out.println(arrayList.size());
        System.out.println(first);
        System.out.println(arrayList);
        System.out.println(arrayList.indexOf("신주연"));
        if (arrayList.contains("신주연")){
            System.out.println("수강신청 성공");
        }else {
            System.out.println("수강신청 실패");
        }
        Collections.sort(arrayList,Collections.reverseOrder());
        System.out.println(arrayList);
        arrayList.clear();
        if(arrayList.isEmpty()){
            System.out.println("비어있습니다");
        }else{
            System.out.println(arrayList.size());
        }
    }
}
