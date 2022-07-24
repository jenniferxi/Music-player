package MusicUtil;

import java.util.List;

/**
 * Repeat one song
 */

public class RepeatOne extends Playlist{

    /**
     * Construct repeating one song
     *
     * @param currentPlaylist the playlist currently playing
     */
    public RepeatOne(List<Song> currentPlaylist) {
        Song s = currentPlaylist.get(0);
        currentPlaylist.add(1, s);
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
