package theme1_java_basic;

import java.util.Arrays;

public class _09_Array {
    public static void main(String[] args) {
        String p1 = "아메리카노";
        String p2 = "라떼";
        String p3 = "카페모카";
        // 베열 선언1
        String[] coffees = new  String[3];
        // 배열 선언2
        String[] coffees2  = new String[] {p1,p2,p3};
        System.out.println(coffees2[0]);
        // 배열 선언3
        String[] coffees3  = {p1,p2,p3};
        System.out.println(coffees3[1]);
        System.out.println("================================");
        // 배열 순회
        for (int i = 0; i < coffees3.length ; i++) {
            System.out.println(coffees3[i]);
        }
        System.out.println("================================");
        // enhanced for(for each)
        for(String coffee : coffees3){
            System.out.println(coffee);
        }
    }
}
