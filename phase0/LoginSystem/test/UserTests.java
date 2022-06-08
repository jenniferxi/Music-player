import org.junit.*;

import static org.junit.Assert.*;

public class UserTests {

    //Get FullName
    @Test
    public void testGetFullName() {
        User testUser = new User("Alice", "Hill", "pizzapizzaisgross");

        Assert.assertEquals("Alice Hill", testUser.getFullName());
    }
}
