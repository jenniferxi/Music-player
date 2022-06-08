import java.io.Serializable;
import java.util.Date;

// Tracks login events;
public class LoginEvent implements Serializable {
    private int userID;
    private Date time;
}
