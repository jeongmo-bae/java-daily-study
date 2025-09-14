package mission2.domain;

public class Account {
    private String accountNo;
    private String ownerName;
    private long balance = 0L;

    public Account(String accountNo, String ownerName, long initailDepositAmount) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance += initailDepositAmount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(String accountNo, long amount){
        validateAmount(amount);
        this.balance += amount;
    }
    public void withdraw(String accountNo, long amount){
        validateAmount(amount);
        this.balance -= amount;
    }
    private void validateAmount(long amount){
        if(amount <= 0){
            throw new RuntimeException("거래 금액이 잘못 되었습니다");
        }
    }

}
