package mission2.repository;

import mission2.domain.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryAccountRepository implements AccountRepository{
    private final Map<String, Account> accountStorage ;

    public MemoryAccountRepository(){
        accountStorage = new HashMap<>();
    }

    @Override
    public void insertAccount(String accountNo, String ownerName , long initailDepositAmount) {
        Account account = new Account(accountNo,ownerName,initailDepositAmount);
        accountStorage.put(accountNo, account);
    }

    @Override
    public Optional<Account> findByAccountNo(String accountNo) {
        return Optional.ofNullable(accountStorage.get(accountNo));
    }

    @Override
    public List<Account> findAll() {
        return accountStorage.values()
                .stream()
                .toList(); //  java16 이전엔 .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(String accountNo) {
        accountStorage.remove(accountNo);
    }

    @Override
    public void updateAccount(String accountNo, Account account) {
        accountStorage.replace(accountNo,account);
    }
}
