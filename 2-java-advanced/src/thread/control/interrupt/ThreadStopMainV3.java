package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread1 = new Thread(myTask,"thread-1");
        thread1.start();
        
        log("sleep 4 sec");
        sleep(50);

        log("작업 중단 지시 thread1.interrupt()");
        thread1.interrupt();
        log("work 스레드 인터럽트 상태1 : " + thread1.isInterrupted());
    }

    static class MyTask implements Runnable{
        
        @Override
        public void run(){
            int cnt = 0;
            while(!Thread.currentThread().isInterrupted()){
                log("작업 중");
                cnt++;
                //log("work 스레드 인터럽트 상태" + (cnt+1) + " : " +  Thread.currentThread().isInterrupted());
            }
            try{
                log("자원 정리 시도");
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch(InterruptedException e){
                log("자원 정리 실패");
                log("work 스레드 인터럽트 상태" + cnt + " : " +  Thread.currentThread().isInterrupted()); // Runnable 이지 여기선
                log("interrupt messege : " + e.getMessage());
                log("state= " + Thread.currentThread().getState());
            }
            log("작업 종료");
        }
    }

}
