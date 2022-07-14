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
        System.out.println("you are now at the login menu");
    }

    public void mainMenu(){
        location = 1;
        System.out.println("you are now at the main menu");
    }

    public void loginMsg(){
        System.out.println("logged in as " + AM.getActiveUser());
    }

    public void logoutMsg(){
        System.out.println("logging out of " + AM.getActiveUser());
    }

    public void loginFail(){
        System.out.println("login failed");
    }

    public void exitMsg(){
        System.out.println("exiting program");
    }

    public void createSuccess(){
        System.out.println("account created successfully");
    }

    public void createFail(){
        System.out.println("an account with this username already exists");
    }

    public void deleteSuccess(){
        System.out.println("account deleted successfully");
    }

    public void deleteFail(){
        System.out.println("account couldn't be found");
    }

    public void getLoginHistory(){
        System.out.println(AM.getUserLoginHistory(AM.getActiveUser()));
    }
}
