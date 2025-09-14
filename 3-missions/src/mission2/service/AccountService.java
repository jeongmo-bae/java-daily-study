package mission2.service;

import mission2.repository.AccountRepository;
import mission2.repository.MemoryAccountRepository;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
