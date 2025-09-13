package mission2.repository;

import mission2.domain.Account;

import java.util.List;

public class MemoryAccountRepository implements AccountRepository{

    @Override
    public Account findByAccountNo(String accountNo) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return List.of();
    }

    @Override
    public void deleteAccount(String accountNo) {

    }

    @Override
    public void updateAccount(String accountNo) {

    }
}
