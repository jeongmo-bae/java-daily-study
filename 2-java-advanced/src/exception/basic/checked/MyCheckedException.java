package exception.basic.checked;

// Exception 을 상속하면 체크 예외가 된다
public class MyCheckedException extends Exception{
    public MyCheckedException(String message) {
        super(message);
    }
}
