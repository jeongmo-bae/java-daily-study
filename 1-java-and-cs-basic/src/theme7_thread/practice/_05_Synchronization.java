package theme7_thread.practice;

import theme7_thread.practice.clean.Room;

// 쓰레드가 동시에 접근해서 문제되는 경우를 해결하기 위해 동기화가 필요해 -> 쓰레드1이 접근한경우 타 쓰레드는 접근을 제한 하는것 (synchronized)
public class _05_Synchronization {
    public static void main(String[] args) {
        Room room  = new Room();

        Runnable cleaner1 = () -> {
            System.out.println("== 직원1 청소 시작(Runnable)  ==");
            for (int i = 1; i <= 5; i ++) {
                if (i==2){
                    throw new RuntimeException("못하겠다");
                }
                room.clean("직원1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("==  직원1 청소 끝(Runnable) ==");
        };
        Runnable cleaner2 = () -> {
            System.out.println("== 직원2 청소 시작(Runnable)  ==");
            for (int i = 1; i <= 5; i ++) {
                room.clean("직원2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("==  직원2 청소 끝(Runnable) ==");
        };
        Thread cleanerThread1 = new Thread(cleaner1);
        Thread cleanerThread2 = new Thread(cleaner2);
        cleanerThread1.start();
        cleanerThread2.start();
    }
}
