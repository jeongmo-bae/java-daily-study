package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread1 = new Thread(myTask,"thread-1");
        thread1.start();
        
        log("sleep 4 sec");
        sleep(4000);

        log("작업 중단 지시 runFlag = false");
        myTask.runFlag = false;

        try{
            thread1.join();
        }catch(InterruptedException e){
            log("InterruptedException Occur : " + e.getMessage());
        }

        log("작업 종료");


    }
    static class MyTask implements Runnable{
        //volatile : 우선은 여러 스레드에서 공유하는 값에 사용하는 키워드
        volatile boolean runFlag = true;
        
        @Override
        public void run(){
            while(runFlag){
                log("작업 중");
                sleep(3000);
                log("자원 정리");
                log("작업 종료");
            }
        }
    }

}
