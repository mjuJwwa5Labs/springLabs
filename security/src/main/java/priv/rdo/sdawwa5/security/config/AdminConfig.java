package priv.rdo.sdawwa5.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import priv.rdo.sdawwa5.security.command.CreateAccountCommand;
import priv.rdo.sdawwa5.security.service.AccountService;

import javax.annotation.PostConstruct;

@Configuration
public class AdminConfig {
    private final AccountService accountService;

    @Autowired
    public AdminConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostConstruct
    private void registerAdmin() {
        accountService.registerNewAccount(
                new CreateAccountCommand(
                        "admin",
                        "password"
                )
        );
    }
}
