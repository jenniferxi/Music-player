import org.junit.*;

import static org.junit.Assert.*;

public class Test {
    @org.junit.Test
    public void testAccount(){
        new Account("CscGroup", "0297");
    }

    @org.junit.Test
    public void testgetUsername(){
        Account a = new Account("CscGroup", "0297");
        assertEquals("CscGroup", a.getUsername());
    }

    @org.junit.Test
    public void testgetPassword(){
        Account a = new Account("CscGroup", "0297");
        assertEquals("0297", a.getPassword());
    }

    @org.junit.Test
    public void testisAdmin(){
        Account a = new Account("CscGroup", "0297");
        assertFalse("isAdmin() should return false\n", a.isAdmin());
    }

    @org.junit.Test
    public void testisBanned(){
        Account a = new Account("CscGroup", "0297");
        assertFalse("isBanned() should return false\n", a.isBanned());
    }

}
