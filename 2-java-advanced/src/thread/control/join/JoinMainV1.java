package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1 {

    static class SumTask implements Runnable{
        int startValue ;
        int endValue;
        int result;

        SumTask(int startValue, int endValue){
            this.startValue = startValue;
            this.endValue = endValue;
        }

        public int getResult() {
            return result;
        }

        @Override
        public void run(){
            sleep(2000);
            log("Start SumTask");
            for (int i = this.startValue; i <= this.endValue; i++) {
                this.result += i;
            }
            log("result : " + this.result);
            log("End SumTask");
        }
    }
    public static void main(String[] args) {
        log("start");
        SumTask sumTask1 = new SumTask(1,50);
        SumTask sumTask2 = new SumTask(51,100);
        
        Thread thread1 = new Thread(sumTask1,"sumTask-1");
        Thread thread2 = new Thread(sumTask2,"sumTask-2");
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            log("ERROR : " + e.getMessage());
        }
        // while (thread1.getState() != Thread.State.TERMINATED | thread2.getState() != Thread.State.TERMINATED ) {
        // }
        // sleep(40);
        log("sumTask1 result : " + sumTask1.getResult());
        log("sumTask2 result : " + sumTask2.getResult());
        log("sumTask1 + sumTask2 : " + (sumTask1.getResult() + sumTask2.getResult()));
        
        log("end");
    }
}
