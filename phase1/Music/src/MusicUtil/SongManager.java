package MusicUtil;

import java.util.ArrayList;
import java.util.Hashtable;

public class SongManager {
    private ArrayList<Song> allSongs = new ArrayList<>();
    private Hashtable<Integer, Song> songMap = new Hashtable<>();
    private static Integer songCount = 0;

    public void addSong(Song song){
        allSongs.add(song);
        songMap.put(songCount, song);
        songCount++;
    }
}
