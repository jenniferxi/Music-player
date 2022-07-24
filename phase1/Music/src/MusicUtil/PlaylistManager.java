package MusicUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages playlists
 */

public class PlaylistManager {
    private Map<String, Favourite> favourites;
    private Map<Integer, CustomPlaylist> playlists;
    private List<Album> albums;
    private int playlistCounter = 0;
    private SongManager SM;
    private CustomPlaylist allSongs = new CustomPlaylist("", "");

    /**
     * Constructs playlist manager with initialized albums, favourites, playlists and song manager
     * @param SM Song manager
     */
    public PlaylistManager(SongManager SM) {
        this.albums = new ArrayList<>();
        this.favourites = new HashMap<>();
        this.playlists = new HashMap<>();
        this.SM = SM;
        allSongs.add(SM.getAllSongs());
    }

    /**
     * Create an album
     *
     * @param name name of album
     * @param artist artist of album
     * @param genre genre of album
     * @param year year published
     * @param musicid list of songs
     * @return true if album has been created
     */
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

    /**
     * Get an album by its name
     *
     * @param name name of the target album
     * @return the list of songs in that album
     */
    public List getAlbumByName(String name) {
        for (Album a : albums) {
            if (name.equals(a.getName())) {
                return a.getMusics();
            }
        }
        return null;
    }

    /**
     * Get albums by genre
     *
     * @param genre the genre to be provided
     * @return the list of albums in that genre
     */
    public List getAlbumByGenre(String genre) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (genre.equals(a.getGenre())) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Get albums by artist name
     *
     * @param artist artist name to be provided
     * @return the list of albums under that artist's name
     */
    public List getAlbumByArtist(String artist) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (artist.equals(a.getArtist())) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Remove an album
     *
     * @param artist artist of the album
     * @param name name of the album
     * @return true if album has been removed
     */
    public boolean removeAlbum(String artist, String name) {
        for (Album a : albums) {
            if (artist.equals(a.getArtist()) && name.equals(a.getName())) {
                albums.remove(a);
                return true;
            }
        }
        return false;
    }

    /**
     * Get all songs
     *
     * @return the playlist containing all songs
     */
    public Playlist getAllSongs() {
        return allSongs;
    }

    /**
     * Create favourite playlist
     *
     * @param owner owner of playlist
     * @param sharable whether playlist is sharable
     */
    public void CreateFavorite(String owner, boolean sharable) {
        Favourite f = new Favourite(owner);
        f.setSharable(sharable);
        favourites.put(owner, f);
    }

    /**
     * Get favourite songs
     *
     * @param owner owner of favourite playlist
     * @return the list of favourited songs
     */
    public List OwnerGetFavMusic(String owner) {
        Favourite f = favourites.get(owner);
        return f.getMusics();
    }

    /**
     * Remove song from favourite playlist
     *
     * @param owner owner of favourite playlist
     * @param songID ID of the target song
     * @return true if song has been removed from favourite playlist
     */
    public boolean removeFavMusic(String owner, Song songID) {
        Favourite f = favourites.get(owner);
        if (f.remove(songID)) {
            favourites.replace(owner, f);
            return true;
        }
        return false;
    }

    /**
     * Share the favourite playlist
     *
     * @param owner owner of the playlist
     * @param recipient recipients of the shared favorite playlist
     */
    public void shareFavorite(String owner, String recipient) {
        Favourite f = favourites.get(owner);
        f.addRecipient(recipient);
        favourites.replace(owner, f);
    }

    /**
     * Set the favourite playlist to public
     *
     * @param owner owner of the playlist
     */
    public void setFavouritePublic(String owner) {
        Favourite f = favourites.get(owner);
        f.setSharable(true);
        favourites.replace(owner, f);

    }

    /**
     * User can access shared favourite playlist
     *
     * @param owner owner of the favourite playlist
     * @param user user
     * @return the list of shared favourited songs
     */
    public List othersAccessSharedFav(String owner, String user) {
        Favourite f = favourites.get(owner);
        List recipients = f.getRecipients();
        if (recipients.contains(user) || f.isSharable()) {
            return f.getMusics();
        }
        return null;
    }

    //break

    /**
     * Create playlist
     *
     * @param name name of playlist
     * @param owner owner of playlist
     * @param sharable whether playlist is sharable
     */
    public int CreatePlaylist(String name, String owner, boolean sharable) {
        CustomPlaylist c = new CustomPlaylist(name, owner);
        c.setSharable(sharable);
        playlists.put(playlistCounter, c);
        playlistCounter++;
        return playlistCounter - 1;
    }

    /**
     * Get playlist
     *
     * @param playlistID ID of the playlist
     * @param owner owner of the playlist
     * @return the list songs from the playlist
     */
    public List OwnerGetPlaylist(int playlistID, String owner) {
        Favourite c = favourites.get(playlistID);
        if (c.owner.equals(owner)) {
            return c.getMusics();
        } else return null;
    }

    /**
     * Remove song from playlist
     *
     * @param playlistID ID of the playlist
     * @param owner owner of the playlist
     * @param songID ID of the song to be removed
     * @return true if song has been removed from playlist
     */
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

    /**
     * Share playlist
     *
     * @param playlistID ID of the playlist
     * @param owner owner of the playlist
     * @param recipient recipients of the shared playlist
     */
    public void sharePlaylist(int playlistID,String owner, String recipient) {
        CustomPlaylist c = playlists.get(playlistID);
        if(c.Owner.equals(owner)){
            c.addRecipient(recipient);
            playlists.replace(playlistID, c);
        }
    }

    /**
     * Set playlist to public
     *
     * @param playlistID ID of the playlist
     * @param owner owner of the playlist
     */
    public void setPlaylistPublic(int playlistID,String owner) {
        CustomPlaylist c = playlists.get(playlistID);
        c.setSharable(true);
        playlists.replace(playlistID, c);

    }

    /**
     * User can access shared playlist
     *
     * @param playlistID ID of playlist
     * @param user user
     * @return the list of shared songs
     */
    public List othersAccessSharedPlaylist(int playlistID, String user) {
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

