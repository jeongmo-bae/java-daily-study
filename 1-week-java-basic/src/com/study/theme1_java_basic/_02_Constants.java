package com.study.theme1_java_basic;

public class _02_Constants {
    public static void main(String[] args) {
        final String  CODE = "KR";
        final float PI = 3.14f;

        //CODE = "US"; // compile error! -> runtime error 가 아니므로 try-catch 불가능
        System.out.printf("Country code is %s",CODE);
        System.out.printf("\nValue of PI is %.2f",PI);

    }
}
