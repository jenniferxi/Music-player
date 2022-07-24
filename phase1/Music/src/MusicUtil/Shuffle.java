package MusicUtil;

import java.util.*;
import java.util.List;

/**
 * Shuffle songs
 */

public class Shuffle extends Playlist{

    /**
     * Construct shuffling songs
     *
     * @param currentPlaylist the playlist currently playing
     */
    public Shuffle(List<Song> currentPlaylist) {
        super();
        Collections.shuffle(currentPlaylist);
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
    public List<Song> getMusics() {
        return super.musics;
    }
}