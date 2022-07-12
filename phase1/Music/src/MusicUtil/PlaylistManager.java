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

    public void CreateAlbum(String name, String artist, String genre,int year, List<Integer> musicid) {
        Album a = new Album(name, artist, genre,year, musicid);
        playlists.add(a);
    }
}
