package exception.ex0ref;

public class ConnectException extends NetworkClientException{
    private final String address;

    public ConnectException(String errorCode, String address, String message) {
        super(errorCode, message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
