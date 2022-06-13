public class Main {
    public static void main(String[] args){
        AccountManager AM = new AccountManager();
        LoginSystem l = new LoginSystem(AM);
        l.display();
    }
}
