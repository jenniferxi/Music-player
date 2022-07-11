package MusicUtil;

import MusicUtil.Album;
import MusicUtil.Favourite;
import MusicUtil.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    private List<Playlist> playlists;

    public PlaylistManager() {
        this.playlists = new ArrayList<>();
        Favourite f = new Favourite();
        playlists.add(f);
    }

    public void CreateAlbum(String name, String artist, List<Integer> musicid) {
        Album a = new Album(name, artist, musicid);
        playlists.add(a);
    }

    public void CreateAlbum(String name, String artist, String genre, List<Integer> musicid) {
        Album a = new Album(name, artist, genre, musicid);
        playlists.add(a);
    }

}
