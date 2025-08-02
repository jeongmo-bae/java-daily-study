package com.study.week1_java_basic;

public class _03_TypeCasting {
    public static void main(String[] args) {
        long score = 9_000_000_000_000L;
        castNumericType(score);
        System.out.printf("\n===============\n");
        castStringType(score);
    }
    public static void castNumericType(long arg) {
        double doubleTypeScore;
        // score = score + 98.8 ; // compile error
        // score += 98.8; // implicit casting : score = score + (int) 98.8;
        arg = arg + (int) 98.8; // explicit casting
        System.out.printf("%d",arg);
        doubleTypeScore = arg - 10.1; // implicit casting int -> long -> float -> double
        System.out.printf("\n");
        System.out.printf("%.2f",doubleTypeScore);
    }
    public static void castStringType(long arg) {
        String score_s = String.valueOf(arg);
        System.out.printf("%s",score_s);

        Long argWrapperLong = new Long(arg);
        score_s = Long.toString(argWrapperLong);
        System.out.printf("\n");
        System.out.printf("%s",score_s);

        int score_i = (int) Long.parseLong(score_s) / 10000;
        score_i = (int) (Long.valueOf(score_s) / 10000); // Long to long, Auto unboxing!!! / 가 기본연산자!

        // 자세히 풀어보자면..
        long longValueForUnboxing = Long.parseLong(score_s) / 10000;
        int intValueForCasting = (int) longValueForUnboxing;
        System.out.printf("\n");
        System.out.printf("%d",intValueForCasting);
        /*
        Long -> int casting 은 불가능! Long 객체의 메서드를 활용해 int 자료형을 떨구거나,수동으로 언박싱 후 캐스팅 필요, Auto unboxing 을 거쳐줘야함
        Long sss = 900L;

        1. Long 객체 메서드를 통한 int 자료형 return (Long 객체 내부엔 long value 가 있겠지? 그걸 (int) 로 캐스팅 해서 반환해 주는 것
        int asd = sss.intValue(); // 언박싱 단계가 없는거지 이건 ㅇㅇ

        2. 수동 언박싱 후 캐스팅
        int asd = (int) sss.longValue();

        3. 위 처럼 연산을 통해 Auto unboxing 유도 하거나 아래처럼 명시적으로 오토언박싱 필요 (long)이 sss.longValue() 호출
        long sss2 = sss;
        int asd = (int) sss2;
        */
    }

}
