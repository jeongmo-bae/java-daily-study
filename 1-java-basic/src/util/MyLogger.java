package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class MyLogger {
    private static final DateTimeFormatter formmatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj){
        String time = LocalTime.now().format(formmatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj );
    }
}
