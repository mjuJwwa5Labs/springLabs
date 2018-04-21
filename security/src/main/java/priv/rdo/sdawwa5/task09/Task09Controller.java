package priv.rdo.sdawwa5.task09;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import priv.rdo.sdawwa5.security.command.CreateAccountCommand;
import priv.rdo.sdawwa5.security.model.Account;
import priv.rdo.sdawwa5.security.service.AccountService;
import priv.rdo.sdawwa5.security.service.CustomUserDetailsService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author marek_j on 2018-04-21
 */
@RestController
@RequestMapping("task09")
public class Task09Controller {

    private AccountService accountService;
    private CustomUserDetailsService customUserDetailsService;

    public Task09Controller(AccountService accountService, CustomUserDetailsService customUserDetailsService) {
        this.accountService = accountService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping
    public ResponseEntity<Account> createUser(@Valid @RequestBody CreateAccountCommand createAccountCommand) {
        Account account = accountService.registerNewAccount(createAccountCommand);
        if (account==null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')") //sprawia, że użytkownicy muszą mieć Authority USER
    public ResponseEntity<List<Account>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
    }

}
