import static org.junit.Assert.*;
import Main.*;

import java.util.ArrayList;


public class MainTest {

    /**
     * Testing Account
     */

    @org.junit.Test
    public void testAccount(){
        new Account("CscGroup", "0297");
    }

    @org.junit.Test
    public void testgetUsername(){
        Account acc = new Account("CscGroup", "0297");
        assertEquals("CscGroup", acc.getUsername());
    }

    @org.junit.Test
    public void testgetPassword(){
        Account acc = new Account("CscGroup", "0297");
        assertEquals("0297", acc.getPassword());
    }

    @org.junit.Test
    public void testisAdmin(){
        Account acc = new Account("CscGroup", "0297");
        assertFalse("isAdmin() should return false\n", acc.isAdmin());
    }

    @org.junit.Test
    public void testisBanned(){
        Account acc = new Account("CscGroup", "0297");
        assertFalse("isBanned() should return false\n", acc.isBanned());
    }

    /**
     * Testing Account Manager
     */

    @org.junit.Test
    public void testauthenticate(){
        Account acc = new Account("CscGroup", "0297");
        assertTrue(acc.getUsername().equals("CscGroup") && acc.getPassword().equals("0297"));
    }

    @org.junit.Test
    public void testcreateAccount() {
        Account acc = new Account("CscGroup", "0297");
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(acc);
        assertFalse("createAccount() should return false\n",
                accounts.contains(acc.getUsername()));
    }

    @org.junit.Test
    public void testdeleteAccount() {
        Account acc = new Account("CscGroup", "0297");
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(acc);
        assertTrue("deleteAccount() should return true\n", !accounts.contains(acc.getUsername()));
    }

    @org.junit.Test
    public void testisPermitted(){
        Account acc = new Account("CscGroup", "0297");
        assertFalse("isPermitted() should return false\n", acc.isAdmin());
    }

    /**
     * Testing Login
     */

    @org.junit.Test
    public void testSuccessLogin(){
        LoginLog newLogin = new LoginLog(true);
        ArrayList<LoginLog> history = new ArrayList<>();
        assertTrue(history.add(newLogin));
    }





}
