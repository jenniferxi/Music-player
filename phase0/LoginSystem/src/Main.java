import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountManager AM = new AccountManager("phase0/LoginSystem/src/accounts.txt");
        LoginSystem l = new LoginSystem(AM);
        l.display();
        AM.updateLog("phase0/LoginSystem/src/accounts.txt");
    }
}
