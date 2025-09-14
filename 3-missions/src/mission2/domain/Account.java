package mission2.domain;

public class Account {
    private String accountNo;
    private String ownerName;
    private long balance = 0L;

    public Account(String accountNo, String ownerName, long initialDeposit) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        validateAmount(initialDeposit);
        this.balance += initialDeposit;
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

    public void deposit(long amount){
        validateAmount(amount);
        this.balance += amount;
    }
    public void withdraw(long amount){
        validateAmount(amount);
        if(balance < amount){
            throw new RuntimeException(accountNo + " : 잔액 부족, 출금 실패");
        } else {
            balance -= amount;
        }
    }
    private void validateAmount(long amount){
        if(amount <= 0){
            throw new RuntimeException("거래 금액이 잘못 되었습니다");
        }
    }

}
