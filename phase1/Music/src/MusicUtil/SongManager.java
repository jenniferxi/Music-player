 package MusicUtil;

import Commands.CommandController;
import Main.AccountManager;
import Main.Program;

import java.io.IOException;
import java.util.*;

 public abstract class SongManager {
    private static ArrayList<Song> allSongs = new ArrayList<>();
    private static Hashtable<Integer, Song> songMap = new Hashtable<>();
    private static HashMap <String, List<Song> > libraryMap = new HashMap<>();
    private static Integer songCount = 0;

    public static void addSong(Song song ){
        song.setId(songCount);
        allSongs.add(song);
        songMap.put(songCount, song);
        songCount++;
    }

    public static void addSongToLibrary(Integer songIndex, String libraryName){
        boolean isExist = checkIfSongExists(songIndex, libraryName);
        if(!isExist) {
            libraryMap.get(libraryName).add(songMap.get(songIndex));
        }
    }

     public static void removeSongFromLibrary(Integer songIndex, String libraryName){
         boolean isExist = checkIfSongExists(songIndex, libraryName);
         if(isExist) {
             libraryMap.get(libraryName).remove(songMap.get(songIndex));
         }
     }

     public static boolean checkIfSongExists(Integer songIndex, String libraryName) {
         List<Song> songList = libraryMap.get(libraryName);
         if(songList==null) {
             Library newLibrary = new Library();
             newLibrary.setName(libraryName);
             songList= new ArrayList<>();
             libraryMap.put(libraryName, songList);
         }
         boolean isExist =false;
         for(Song song: songList){
             if (song.getId() == songIndex) {
                 isExist = true;
                 break;
             }
         }
         return isExist;
     }

     public static List<Song> getSongsFromLibrary(String library){
        return libraryMap.get(library);
     }

     // for testing purposes
     public static void main(String[] args) throws IOException {
        Song song1 = new Song("song1");
        Song song2 = new Song("song2");
        Song song3 = new Song("song3");
        SongManager.addSong(song1);
        SongManager.addSong(song2);
         SongManager.addSong(song3);
         String libraryName = "library 1";
         SongManager.addSongToLibrary(song1.getId(), libraryName);
         SongManager.addSongToLibrary(song2.getId(), libraryName);
         SongManager.addSongToLibrary(song3.getId(), libraryName);
         for(Song song:SongManager.getSongsFromLibrary(libraryName)){
             System.out.println("Song name:"+ song.getName());
         }
         SongManager.removeSongFromLibrary(song3.getId(), libraryName);
         for(Song song:SongManager.getSongsFromLibrary(libraryName)){
             System.out.println("Song name:"+ song.getName());
         }
     }


}
