import java.util.Date;
public class User {

    // User ID

    private int id;

    private String firstName;
    private String lastName;
    private Date lastLogin;
    private String  password;
    private boolean enabled;

    public User(String firstName, String lastName, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        enabled = true;
    }
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    // User ID 0 is always the administrator
    public boolean isAdmin()
    {
        return id == 0 ? true : false;
    }

}
