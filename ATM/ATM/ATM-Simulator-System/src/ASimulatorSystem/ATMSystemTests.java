import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class ATMSystemTests {

    private Login login;
    private Transactions transactions;
    private BalanceEquiry balanceEnquiry;

    @Before
    public void setUp() {
        // Initialize instances for each class
        login = new Login();
        transactions = new Transactions();
        balanceEnquiry = new BalanceEquiry();
    }

    // =======================
    // Tests for Login.java
    // =======================

    @Test
    public void testSuccessfulLogin() {
        boolean result = login.authenticate("correctUsername", "correctPassword");
        assertTrue("Login should succeed with correct username and password", result);
    }

    @Test
    public void testFailedLogin() {
        boolean result = login.authenticate("wrongUsername", "wrongPassword");
        assertFalse("Login should fail with incorrect username and password", result);
    }

    @Test
    public void testNullUsername() {
        boolean result = login.authenticate(null, "somePassword");
        assertFalse("Login should fail when username is null", result);
    }

    @Test
    public void testNullPassword() {
        boolean result = login.authenticate("someUsername", null);
        assertFalse("Login should fail when password is null", result);
    }

    @Test
    public void testEmptyCredentials() {
        boolean result = login.authenticate("", "");
        assertFalse("Login should fail when username and password are empty", result);
    }

    // ============================
    // Tests for Transactions.java
    // ============================

    @Test
    public void testWithdraw() {
        transactions.setBalance(1000);
        transactions.withdraw(500);
        assertEquals(500, transactions.getBalance());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        transactions.setBalance(1000);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            transactions.withdraw(1500);
        });
        assertEquals("Insufficient balance", thrown.getMessage());
    }

    @Test
    public void testDeposit() {
        transactions.setBalance(1000);
        transactions.deposit(500);
        assertEquals(1500, transactions.getBalance());
    }

    // =============================
    // Tests for BalanceEquiry.java
    // =============================

    @Test
    public void testGetBalance() {
        balanceEnquiry.setBalance(1000);
        assertEquals(1000, balanceEnquiry.getBalance());
    }
}
