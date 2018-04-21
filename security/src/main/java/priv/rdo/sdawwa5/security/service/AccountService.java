package priv.rdo.sdawwa5.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import priv.rdo.sdawwa5.security.command.CreateAccountCommand;
import priv.rdo.sdawwa5.security.model.Account;
import priv.rdo.sdawwa5.security.model.UsernameExistsException;
import priv.rdo.sdawwa5.security.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Account registerNewAccount(CreateAccountCommand command) {
        if (usernameExists(command.getUsername())) {
            throw new UsernameExistsException(command.getUsername());
        }

        return accountRepository.save(
                new Account(
                        command.getUsername(),
                        passwordEncoder.encode(command.getPassword())
                )
        );

    }

    private boolean usernameExists(String username) {
        return accountRepository.findByUsername(username) != null;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
