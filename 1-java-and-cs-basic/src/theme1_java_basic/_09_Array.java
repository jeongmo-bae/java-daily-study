package theme1_java_basic;

import java.util.Arrays;

public class _09_Array {
    public static void main(String[] args) {
        String p1 = "아메리카노";
        String p2 = "라떼";
        String p3 = "카페모카";
        // 베열 선언1
        String[] coffees = new  String[3];
        coffees[0] = "asd";
        coffees[1] = "asd";
        coffees[2] = "asd";
        System.out.println(Arrays.toString(coffees));
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
        // Array Of Array
        System.out.println("================================");
        int[][] arrayOfArray = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,0}
        };
        System.out.println(Arrays.deepToString(arrayOfArray));
        System.out.println("================================");
        int[][] arrayOfArray2 = {
                {1,2,3},
                {4,5,6,7},
                {8,9,0,10,11}
        };
        for (int[] array : arrayOfArray2){
            System.out.println(Arrays.toString(array));
        }
        System.out.println("================================");
        for (int i = 0; i < arrayOfArray2.length; i++) {
            for (int j = 0; j < arrayOfArray2[i].length; j++) {
                System.out.println(arrayOfArray2[i][j]);
            }
        }
    }
}
