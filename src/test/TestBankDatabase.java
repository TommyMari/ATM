package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.Business_logic.Euro;
import code.Database.BankDatabase;

public class TestBankDatabase {

    private BankDatabase bankDatabase;
    private int accountNumber1 = 12345;
    private int pin1 = 54321;
   

    @Before
    public void setUp() {
        bankDatabase = new BankDatabase();
    }

    @Test
    public void testAuthenticateUser_CorrectCredentials() {
        assertTrue(bankDatabase.authenticateUser(accountNumber1, pin1));
    }

    @Test
    public void testAuthenticateUser_IncorrectCredentials() {
        assertFalse(bankDatabase.authenticateUser(accountNumber1, 0000));
    }

    @Test
    public void testGetAvailableBalance() {
        Euro expectedBalance = new Euro(1000.0);
        assertEquals(expectedBalance.getValore(), bankDatabase.getAvailableBalance(accountNumber1).getValore()); 
    }

    @Test
    public void testGetTotalBalance() {
        Euro expectedTotalBalance = new Euro(1200.0);
        assertEquals(expectedTotalBalance.getValore(), bankDatabase.getTotalBalance(accountNumber1).getValore());
    }

    @Test
    public void testCredit() {
        Euro creditAmount = new Euro(500.0);
        bankDatabase.credit(accountNumber1, creditAmount);
        Euro expectedTotalBalance = new Euro(1700.0);
        assertEquals(expectedTotalBalance.getValore(), bankDatabase.getTotalBalance(accountNumber1).getValore());
    }

    @Test
    public void testDebit() {
        Euro debitAmount = new Euro(300.0);
        bankDatabase.debit(accountNumber1, debitAmount);
        Euro expectedAvailableBalance = new Euro(700.0);
        Euro expectedTotalBalance = new Euro(900.0);
        assertEquals(expectedAvailableBalance.getValore(), bankDatabase.getAvailableBalance(accountNumber1).getValore());
        assertEquals(expectedTotalBalance.getValore(), bankDatabase.getTotalBalance(accountNumber1).getValore());
    }
}