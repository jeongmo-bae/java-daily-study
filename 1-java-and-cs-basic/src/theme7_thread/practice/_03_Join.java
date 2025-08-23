package theme7_thread.practice;

import theme7_thread.practice.clean.CleanRunnable;

public class _03_Join {
    public static void main(String[] args) {
        CleanRunnable cleanRunnable = new CleanRunnable();
        Thread thread = new Thread(cleanRunnable);
        thread.start();
        try {
            thread.join(2500);  // 이 쓰레드가 끝날때까지 기다리라는 것, 2500ms 까진 기다려보고 아니면 Main Thread 실행
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cleanByBoss(); // Main Thread
    }
    public static void cleanByBoss() {
        System.out.println("== 사장 청소 시작  ==");
        for (int i = 1; i <= 10 ; i+=2) {
            System.out.println("(사장) " + i + "번방 청소 중");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("==  사장 청소 끝 ==");
    }
}
