package Main;

import MusicUtil.Playlist;
import MusicUtil.PlaylistManager;
import MusicUtil.Song;
import MusicUtil.SongManager;
import jaco.mp3.player.MP3Player;

public class Program {
    private boolean running;
    private AccountManager AM;
    private int location;

    private SongManager SM;

    private MP3Player player = new MP3Player();

    private Playlist currPlaylist;
    private PlaylistManager PM;

    public Program(AccountManager accountManager, SongManager songManager, PlaylistManager playlistManager){
        this.running =true;
        AM = accountManager;
        SM = songManager;
        PM = playlistManager;
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

    public void allSongs(){
        location = 2;
        for(Song song : SM.getAllSongs()){
            System.out.println(song.artistTitleAlbum() + " " + song.getId());
        }
        setCurrentPlaylist(PM.getAllSongs());
    }

    private void setCurrentPlaylist(Playlist playlist){
        currPlaylist = playlist;
    }

    public void play(){
        currPlaylist.play(player);
    }

    public void pause(){
        player.pause();
    }

    public void stop(){
        player.stop();
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
