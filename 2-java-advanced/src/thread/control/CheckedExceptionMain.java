package thread.control;

import javax.swing.TransferHandler;

import util.ThreadUtils;
import static util.MyLogger.log;

public class CheckedExceptionMain {
    public static void main(String[] args){
        Thread thread = new Thread(()  -> {
            log("ThreadUtils.sleep(1000) start");
            ThreadUtils.sleep(1000);
            log("ThreadUtils.sleep(1000) end");
        });
        thread.start();
    }

    // 메서드 오버라이딩시, 부모 메서크의 체크예르를 따라감. Runnable 의 run 체크예외 안던지니까 안됨
    // 이거 왜 그럴까? -> 다형성에 따른 컴파일 타임과 런타임을 나눠 생각해봐야해
    // Parent p = new Child();
    // p.method(); 
    // 여기서 컴파일 타임엔, 부모의 메서드에서 던는 체크예외를 예상함 - 컴파일 타임
    // 실제로는 자식 클래스에서 오버라이딩한 메서드가 실행되는데 여기서 전혀 다른 체크예외를 던지면, 잡을 수가 없다 - 런타임 
    // 따라서 자식 클래스에서 재정의(오버라이딩)한 메서드는 부모 메서드에서 던질 수 있는 체크예외의 하위 타입만 던질 수 있다.
    // static class CheckedRunnable implements Runnable{
    //     @Override
    //     public void run() /*throws Exception*/ {
    //         //throw new Exception();
    //         try{
    //             Thread.sleep(1000);
    //         }catch(InterruptedException e) {
    //             throw new RuntimeException();  // 언체크 예외로 던져버리는건 가능하지
    //         }
    //     }
    // }
    // 왜 Runnable 은 체크예외를 못 던지게 해놨을까?
    // 무조건 처리하게 함으로써, 멀티스레드 환경에서 스레드 안정성과 일관성을 유지할 수 있다는 장점이 있다.
}
