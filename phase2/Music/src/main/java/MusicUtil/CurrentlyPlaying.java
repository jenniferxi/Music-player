package main.java.MusicUtil;

import java.util.List;

/**
 * The song and playlist that is currently playing
 */

public class CurrentlyPlaying extends Playlist {

    /** Constructs the song currently playing
     *
     * @param musicid ID of song
     */
    public CurrentlyPlaying(Song musicid) {
        super();
        super.musics.add(musicid);
    }

    /**
     * Constructs the playlist currently playing
     *
     * @param p playlist
     */
    public CurrentlyPlaying(Playlist p) {
        super();
        super.musics.addAll(p.musics);
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
