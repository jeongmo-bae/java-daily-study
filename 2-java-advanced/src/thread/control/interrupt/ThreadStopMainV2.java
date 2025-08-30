package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread1 = new Thread(myTask,"thread-1");
        thread1.start();
        
        log("sleep 4 sec");
        sleep(4000);

        log("작업 중단 지시 thread1.interrupt()");
        thread1.interrupt();
        log("work 스레드 인터럽트 상태1 : " + thread1.isInterrupted());
    }

    static class MyTask implements Runnable{
        
        @Override
        public void run(){
            try{
                while(true){
                    log("작업 중");
                    Thread.sleep(3000);    // Exception 터져야하는데 내 커스텀 메서드인 sleep 을 쓰면, 내부에서 잡아버리기 때문에 익셉션이 안나!            
                }
            } catch(InterruptedException e){

                log("work 스레드 인터럽트 상태2 : " + Thread.currentThread().isInterrupted());
                log("interrupt messege : " + e.getMessage());
                log("state= " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");
        }
    }

}
