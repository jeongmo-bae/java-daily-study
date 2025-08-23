package theme7_thread.thread.control;

import theme7_thread.thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log("start");
            log("myThread.state2 = " + Thread.currentThread().getState());
            try {
                log("sleep start");
                Thread.sleep(2000);
                log("sleep end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("end");

        },"myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        for (int i = 0; i < 10; i++) {
            if(thread.getState() == Thread.State.TERMINATED){
                log("myThread.state4 = " + thread.getState());
                log("myThread END");
                break;
            } else if (thread.getState() == Thread.State.RUNNABLE) {
                Thread.sleep(1000);
            } else{
                log("myThread.state3 = " + thread.getState());
                Thread.sleep(2000);
            }
        }
    }
}
