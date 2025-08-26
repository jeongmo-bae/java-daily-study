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
            log("Start SumTask");
            for (int i = this.startValue; i < this.endValue + 1; i++) {
                this.result += i;
                log("+ " + i + " and sleep 1 sec");
                sleep(1000);
            }
            log("result : " + this.result);
            log("End SumTask");
        }
    }
    public static void main(String[] args) {
        log("start");
        SumTask sumTask = new SumTask(2,8);
        Thread thread = new Thread(sumTask,"thread-1");
        thread.start();
        sleep(2000);
        log("result : " + sumTask.getResult());
        log("end");
    }
}
