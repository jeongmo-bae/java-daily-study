package testPackage.asynchronous;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainCallable {
    public static void main(String[] args) {
        
        Callable<Integer> callableTest = () -> {
            return 1;
        } ;
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<Integer> f = pool.submit(callableTest);
        try{
            Integer result = f.get();
            System.out.println(result);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } catch(ExecutionException e){
            Throwable cause = e.getCause();
            cause.printStackTrace();
        }       
    }
}
