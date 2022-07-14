package MusicUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlaylistManager {
    private List<Playlist> playlists;//change to map
    private Map<String, Favourite> favourites;

    public PlaylistManager() {
        this.playlists = new ArrayList<>();
    }

    public void CreateAlbum(String name, String artist, String genre, int year, List<Integer> musicid) {
        Album a = new Album(name, artist, genre, year, musicid);
        playlists.add(a);
    }

    public void CreateFavorite(String owner, boolean sharable) {
        Favourite f = new Favourite(owner);
        favourites.put(owner, f);
    }

    public List OwnerGetFavMusic(String owner) {
        Favourite f = favourites.get(owner);
        return f.getMusics();
    }

    public boolean removeFavMusic(String owner, Integer songID) {
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

}
