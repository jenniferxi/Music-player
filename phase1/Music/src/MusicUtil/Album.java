package MusicUtil;

import java.util.List;

public class Album extends Playlist {
    private final String artist;
    private String genre;

    public Album(String name, String artist, List<Integer> musicid) {
        super(name);
        this.artist = artist;
        musics = musicid;
    }

    public Album(String name, String artist, String genre, List<Integer> musicid) {
        super(name);
        this.artist = artist;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }
}
