package MusicUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages all playlists
 */

public class PlaylistManager {
    private Map<String, Favourite> favourites;
    private Map<Integer, CustomPlaylist> playlists;
    private List<Album> albums;
    private int playlistCounter = 0;
    private SongManager SM;
    private CustomPlaylist allSongs = new CustomPlaylist("", "");


    public PlaylistManager(SongManager SM) {
        this.albums = new ArrayList<>();
        this.favourites = new HashMap<>();
        this.playlists = new HashMap<>();
        this.SM = SM;
        allSongs.add(SM.getAllSongs());
    }

    public boolean CreateAlbum(String name, String artist, String genre, int year, List<Song> musicid) {
        for (Album a : albums) {
            if (name.equals(a.getName()) && artist.equals(a.getArtist())) {
                return false;
            }
        }
        Album a = new Album(name, artist, genre, year, musicid);
        albums.add(a);
        return true;
    }

    public List getAlbumByName(String name) {
        for (Album a : albums) {
            if (name.equals(a.getName())) {
                return a.getMusics();
            }
        }
        return null;
    }

    public List getAlbumByGenre(String genre) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (genre.equals(a.getGenre())) {
                result.add(a);
            }
        }
        return result;
    }

    public List getAlbumByArtist(String artist) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (artist.equals(a.getArtist())) {
                result.add(a);
            }
        }
        return result;
    }

    public boolean removeAlbum(String artist, String name) {
        for (Album a : albums) {
            if (artist.equals(a.getArtist()) && name.equals(a.getName())) {
                albums.remove(a);
                return true;
            }
        }
        return false;
    }

    public Playlist getAllSongs() {
        return allSongs;
    }

    public void CreateFavorite(String owner, boolean sharable) {
        Favourite f = new Favourite(owner);
        f.setSharable(sharable);
        favourites.put(owner, f);
    }

    public List OwnerGetFavMusic(String owner) {
        Favourite f = favourites.get(owner);
        return f.getMusics();
    }

    public boolean removeFavMusic(String owner, Song songID) {
        Favourite f = favourites.get(owner);
        if (f.remove(songID)) {
            favourites.replace(owner, f);
            return true;
        }
        return false;
    }

    public void shareFavorite(String owner, String recipient) {
        Favourite f = favourites.get(owner);
        f.addRecipient(recipient);
        favourites.replace(owner, f);
    }

    public void setFavouritePublic(String owner) {
        Favourite f = favourites.get(owner);
        f.setSharable(true);
        favourites.replace(owner, f);

    }

    public List othersAccessSharedFav(String owner, String user) {
        Favourite f = favourites.get(owner);
        List recipients = f.getRecipients();
        if (recipients.contains(user) || f.isSharable()) {
            return f.getMusics();
        }
        return null;
    }

    //break
    public int CreatePlaylist(String name, String owner, boolean sharable) {
        CustomPlaylist c = new CustomPlaylist(name, owner);
        c.setSharable(sharable);
        playlists.put(playlistCounter, c);
        playlistCounter++;
        return playlistCounter - 1;
    }

    public List OwnerGetPlaylist(int playlistID, String owner) {
        Favourite c = favourites.get(playlistID);
        if (c.owner.equals(owner)) {
            return c.getMusics();
        } else return null;
    }

    public boolean removeMusicInPlaylist(int playlistID, String owner, Song songID) {
        CustomPlaylist c = playlists.get(playlistID);
        if (c.Owner.equals(owner)) {
            if (c.remove(songID)) {
                playlists.replace(playlistID, c);
                return true;
            }
        }
        return false;
    }

    public void sharePlaylist(int playlistID,String owner, String recipient) {
        CustomPlaylist c = playlists.get(playlistID);
        if(c.Owner.equals(owner)){
            c.addRecipient(recipient);
            playlists.replace(playlistID, c);
        }
    }

    public void setPlaylistPublic(int playlistID,String owner) {
        CustomPlaylist c = playlists.get(playlistID);
        c.setSharable(true);
        playlists.replace(playlistID, c);

    }

    public List othersAccessSharedFav(int playlistID, String user) {
        CustomPlaylist f = playlists.get(playlistID);
        List recipients = f.getRecipients();
        if (recipients.contains(user) || f.isSharable()) {
            return f.getMusics();
        }
        return null;
    }


    //For test purpose only
    public static void main(String[] args) {
        SongManager SM = new SongManager();
        PlaylistManager p = new PlaylistManager(SM);
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
//        System.out.println(p.CreateAlbum("Whenever You Need Somebody", "Rick Astley", "pop", 1987, temp));
//        System.out.println(p.CreateAlbum("Whenever You Need Somebody", "Rick Astley", "pop", 1987, temp));
//        System.out.println(p.CreateAlbum("Mylo Xyloto", "Coldplay", "alternative", 2011, temp));
        System.out.println(p.getAlbumByArtist("TheFatRat"));
        System.out.println(p.getAlbumByArtist("Coldplay"));
        System.out.println(p.getAlbumByGenre("hip pop"));
        System.out.println(p.getAlbumByGenre("pop"));
        System.out.println(p.getAlbumByName("Mylo Xyloto"));
        System.out.println(p.getAlbumByName("Monody"));
        System.out.println(p.removeAlbum("Rick Astley", "Whenever You Need Somebody"));
        System.out.println(p.removeAlbum("TheFatRat", "Monody"));
    }
}

