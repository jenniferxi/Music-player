 package MusicUtil;

import Commands.CommandController;
import Main.AccountManager;
import Main.Program;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.io.IOException;
import java.util.*;

 public class SongManager {
    private static ArrayList<Song> allSongs = new ArrayList<>();
    private static Hashtable<Integer, Song> songMap = new Hashtable<>();
    private static HashMap <String, List<Song> > libraryMap = new HashMap<>();
    private static Integer songCount = 0;
    private File songFile = new File("songs");

    public static void addSong(Song song ){
        song.setId(songCount);
        allSongs.add(song);
        songMap.put(songCount, song);
        songCount++;
    }

    public List<Song> getAllSongs(){
        return allSongs;
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

     public void initializeSongs() throws Exception{
        try{
            for(File file : Objects.requireNonNull(songFile.listFiles())){
                List<String> info = getInfo(new Mp3File(file));
                Song song = new Song(info.get(0), info.get(1), info.get(2), info.get(3), file.getPath());
                addSong(song);
            }

        }
        catch(NullPointerException e){
            System.out.println("song file empty...");
        }
     }

     private List<String> getInfo(Mp3File file){
        List<String> info = new ArrayList<>();
        if(file.hasId3v2Tag()){
            ID3v2 tag = file.getId3v2Tag();
            info.add(tag.getTitle());
            info.add(tag.getAlbum());
            info.add(tag.getArtist());
            info.add(tag.getGenreDescription());
        }
        return info;
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
