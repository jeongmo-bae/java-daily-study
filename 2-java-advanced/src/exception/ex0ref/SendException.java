package exception.ex0ref;

public class SendException extends NetworkClientException {
    private final String data;

    public SendException(String errorCode, String data, String message) {
        super(errorCode, message);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
