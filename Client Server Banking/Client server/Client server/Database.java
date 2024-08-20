import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Account> accounts;

    public Database() {
        accounts = new HashMap<>();
    }

    public void addAccount(String username, String password) {
        accounts.put(username, new Account(username, password));
    }

    public boolean authenticate(String username, String password) {
        Account account = accounts.get(username);
        return account != null && account.getPassword().equals(password);
    }
}
