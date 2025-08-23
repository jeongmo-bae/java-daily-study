package theme7_thread.thread.start.test;

import static util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        new Thread(new CounterRunnable("A",0.5),"Thread-A").start();
        new Thread(new CounterRunnable("B",0.25),"Thread-B").start();
    }
    static class CounterRunnable implements Runnable{
        private String workName;
        private double sleepTime;
        CounterRunnable(String workName,double sleepTime){
            this.workName = workName;
            this.sleepTime = sleepTime;
        }
        public long getSleepTime() {
            return (long) (sleepTime*1000);
        }
        public String getWorkName() {
            return workName;
        }
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                log(" " + getWorkName() + "-" + (i+1));
                try {
                    Thread.sleep(getSleepTime());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
