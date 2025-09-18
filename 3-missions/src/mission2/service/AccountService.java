package mission2.service;

import mission2.domain.Account;
import mission2.repository.AccountRepository;
import mission2.repository.MemoryAccountRepository;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String makeAccount(String accountNo, String ownerName, long initialDeposit){
        if (accountRepository.findByAccountNo(accountNo).isPresent()){
            throw new RuntimeException("이미 존재하는 계좌번호입니다!");
        }
        Account account = new Account(accountNo,ownerName,initialDeposit);
        accountRepository.insertAccount(accountNo,account);
        return  String.format("accountNo : %s, balance : %d , 계좌 개설이 완료 되었습니다.",accountNo,initialDeposit);
    }

    public String depositToAccount(String accountNo,long amount){
        Account account = accountRepository
                .findByAccountNo(accountNo)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 계좌입니다."));
        account.deposit(amount);
//        accountRepository.updateAccount(accountNo,account);   MemoryRepository 에선 의미가 없어. 참조 넘기니까
        return String.format("입금 완료! 현재 잔액 : %d",account.getBalance());
    }

    public String withdrawFromAccount(String accountNo, long amount){
        Account account = accountRepository
                .findByAccountNo(accountNo)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 계좌입니다."));
        account.withdraw(amount);
        return String.format("출금 완료! 현재 잔액 : %d",account.getBalance());
    }

    public String findBalance(String accountNo){
        Account account = accountRepository
                .findByAccountNo(accountNo)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 계좌입니다."));
        return String.format("현재 잔액 : %d",account.getBalance());
    }

    public String findAllAccounts(){
        List<Account> accountList = accountRepository.findAll();
        StringBuffer returnVal = new StringBuffer() ;
        for(Account account : accountList){
            returnVal.append(String.format("계좌번호 : %s | 예금주 : %s | 잔액 : %d\n",account.getAccountNo(),account.getOwnerName(),account.getBalance()));
        }
        return returnVal.toString();
    }
}
