package MusicUtil;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Repeat all songs in the playlist
 */

public class RepeatAll extends Playlist{

    /**
     * Construct repeating all songs
     *
     * @param currentPlaylist the playlist currently playing
     */
    public RepeatAll(List<Song> currentPlaylist) {
        // TODO: Loop the current playlist
        Song s = currentPlaylist.get(0);
        currentPlaylist.remove(0);
        currentPlaylist.add(s);
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