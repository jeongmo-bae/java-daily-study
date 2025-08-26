package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("Start");
        Runnable runnable = () -> {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        };

        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");
        
        thread1.start();
        thread2.start();
        
        // try{
        //     Thread.join(1000);
        // }catch(InterruptedException e){
        //     log("InterruptedException : " + e.getMessage());
        // }
        log("End");
    }
}
