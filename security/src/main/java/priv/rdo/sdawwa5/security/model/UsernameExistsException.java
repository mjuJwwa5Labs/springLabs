package priv.rdo.sdawwa5.security.model;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String username) {
        super("There is an account with that username: " + username);
    }
}
