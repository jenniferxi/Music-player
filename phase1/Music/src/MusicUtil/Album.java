package MusicUtil;

import java.util.List;

public class Album extends Playlist {
    public final String artist;
    public final String genre;
    public final int releaseYear;

    public Album(String name, String artist, String genre, int year, List<Integer> musicid) {
        super(name);
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = year;
        musics = musicid;
    }

    @Override
    public boolean add(Integer musicid) {
        return false;
    }

    @Override
    public boolean remove(Integer musicid) {
        return false;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public boolean isSharable() {
        return true;
    }

    @Override
    public List getMusics() {
        return super.musics;
    }

}
