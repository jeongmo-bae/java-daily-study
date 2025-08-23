package thread.start.test;

import static util.MyLogger.log;

public class CounterThread extends Thread{
    private static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            setCount();
            log("value : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void setCount(){
        CounterThread.count++;
    }
}