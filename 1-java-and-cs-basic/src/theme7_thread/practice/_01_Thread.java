package theme7_thread.practice;

import theme7_thread.practice.clean.CleanThread;

public class _01_Thread {
    public static void main(String[] args) {
        //쓰레드
        // 1 3 5 7 9
        // 2 4 6 8 10
        CleanThread cleanThread = new CleanThread();
        //cleanThread.run(); //직접 호출하면 안돼
        cleanThread.start(); // Main Thread 가아닌 새로운 Thread 를 생성해 수행시켜준다

        cleanByBoss();
    }

    public static void cleanByBoss() {
        System.out.println("== 사장 청소 시작  ==");
        for (int i = 1; i <= 10 ; i+=2) {
            System.out.println("(사장) " + i + "번방 청소 중");
        }
        System.out.println("==  사장 청소 끝 ==");
    }
}
