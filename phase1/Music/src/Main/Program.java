package Main;

public class Program {
    private boolean running;
    private AccountManager AM;
    private int location;

    public Program(AccountManager accountManager){
        this.running =true;
        AM = accountManager;
        location = 0;
    }

    public boolean isRunning(){
        return running;
    }

    public void stopRunning(){
        running = false;
    }

    public int getLocation(){
        return location;
    }

    public void loginDisplay(){
        location = 0;
        System.out.println("Enter \"login\" to login, \"create\" " +
                "to create a new account, or \"exit\" to exit the program.");
    }

    public void mainMenu(){
        location = 1;
        System.out.println("Welcome to the main menu. Enter \"logout\" to log out, or" +
                " \"history\" to see your login history.");
    }
}
