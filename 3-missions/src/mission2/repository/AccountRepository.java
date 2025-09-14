package mission2.repository;

import mission2.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    void insertAccount(String accountNo, Account account);
    Optional<Account> findByAccountNo(String accountNo);
    List<Account> findAll();
    void deleteAccount(String accountNo);
    void updateAccount(String accountNo,Account account);
}
