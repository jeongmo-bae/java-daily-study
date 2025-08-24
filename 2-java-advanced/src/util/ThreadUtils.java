package util;

import static util.MyLogger.log;

public final class ThreadUtils {
    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch( InterruptedException e ){
            log("Interrupt Occur, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
