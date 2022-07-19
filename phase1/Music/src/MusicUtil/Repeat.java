package MusicUtil;

import java.util.*;
import java.util.List;

public class Repeat extends Playlist{

    public Repeat(List<Song> currentPlaylist) {

        super();

        // while loop for repeating the playlist
        System.out.println(currentPlaylist);
    }

    @Override
    public boolean add(List<Song> songs) {
        super.musics.addAll(songs);
        return true;
    }

    @Override
    public boolean remove(Song musicid) {
        return (super.musics.remove(musicid));
    }

    @Override
    public boolean empty() {
        super.musics.clear();
        return true;
    }

    @Override
    public boolean isSharable() {
        return false;
    }

    @Override
    public List getMusics() {
        return super.musics;
    }
}
