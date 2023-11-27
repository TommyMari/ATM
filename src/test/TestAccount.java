package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.Business_logic.Account;
import code.Business_logic.Euro;

public class TestAccount {

    private Account account;
    private Euro initialAvailableBalance;
    private Euro initialTotalBalance;
    private int accountNumber = 123456;
    private int pin = 1234;

    @Before
    public void setUp() {
        initialAvailableBalance = new Euro(1000);
        initialTotalBalance = new Euro(1500);
        account = new Account(accountNumber, pin, initialAvailableBalance, initialTotalBalance);
    }

    @Test
    public void testValidatePIN_CorrectPIN() {
        assertTrue(account.validatePIN(pin));
    }

    @Test
    public void testValidatePIN_IncorrectPIN() {
        assertFalse(account.validatePIN(0000));
    }

    @Test
    public void testGetAvailableBalance() {
        assertEquals(initialAvailableBalance, account.getAvailableBalance());
    }

    @Test
    public void testGetTotalBalance() {
        assertEquals(initialTotalBalance, account.getTotalBalance());
    }

    @Test
    public void testCredit() {
        Euro creditAmount = new Euro(500);
        account.credit(creditAmount);
        Euro expectedTotalBalance = initialTotalBalance.somma(creditAmount);
        assertEquals(expectedTotalBalance, account.getTotalBalance());
    }

    @Test
    public void testDebit() {
        Euro debitAmount = new Euro(300);
        account.debit(debitAmount);
        Euro expectedAvailableBalance = initialAvailableBalance.sottrai(debitAmount);
        Euro expectedTotalBalance = initialTotalBalance.sottrai(debitAmount);
        assertEquals(expectedAvailableBalance, account.getAvailableBalance());
        assertEquals(expectedTotalBalance, account.getTotalBalance());
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals(accountNumber, account.getAccountNumber());
    }
}