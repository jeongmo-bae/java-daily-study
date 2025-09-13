package mission2.repository;

import mission2.domain.Account;

import java.util.List;

public interface AccountRepository {
    Account findByAccountNo(String accountNo);
    List<Account> findAll();
    void deleteAccount(String accountNo);
    void updateAccount(String accountNo);
}
