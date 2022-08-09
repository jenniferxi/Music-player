package persistence;

import MusicUtil.Album;
import MusicUtil.CustomPlaylist;
import MusicUtil.Favourite;
import MusicUtil.Playlist;
import MusicUtil.Song;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test cases for PersistenceService. Tests whether user playlists are stored after
 * the user logs out and logs back in.
 *
 * @author Jennifer Xi
 * @version 1.0
 * @since 2022-08-03
 */
public class PersistenceServiceTest {

    @Test
    public void testPersistFavourites() {
        // Get persistenceService
        PersistenceService persistenceService = PersistenceService.getPersistenceService();
        // create new Favourite
        String playListName = "Favourites playlist";
        Favourite inFavourite = new Favourite("Jennifer");
        inFavourite.setName(playListName);
        // persist favourite using persistenceService
        persistenceService.persistPlayList(inFavourite);
        // retrieve favourite from file system by name
        Favourite outfavourite =(Favourite) persistenceService.getPlayListByName(playListName);
        // verify the retrieved favourite playlist has the same values as the
        // originally stored favourite playlist
        assert outfavourite.getName().equals(playListName);
        assert outfavourite.getOwner().equals("Jennifer");
    }

    @Test
    public void testPersistCustomPlaylist() {
        // Get persistenceService
        PersistenceService persistenceService = PersistenceService.getPersistenceService();
        // create new CustomPlaylist
        String playListName = "Custom Playlist";
        CustomPlaylist inPlaylist = new CustomPlaylist(playListName, "Lindsey");
        // persist CustomPlaylist using persistenceService
        persistenceService.persistPlayList(inPlaylist);
        // retrieve CustomPlaylist from file system by name
        CustomPlaylist outplaylist =(CustomPlaylist) persistenceService.getPlayListByName(playListName);
        // verify the retrieved CustomPlaylist has the same values as the originally stored Playlist
        assert outplaylist.getName().equals(playListName);
        assert outplaylist.getOwner().equals("Lindsey");
    }

    @Test
    public void testPersistAlbumNoSongs() {
        // Get persistenceService
        PersistenceService persistenceService = PersistenceService.getPersistenceService();
        // create new CustomPlaylist
        String playListName = "New Album";
//        Song newsong = new Song("Read All Over", "Youtube", "Nathan Moore", "Pop",
//                "phase2/Music/songs/Read All Over - Nathan Moore.mp3");
        List<Song> songlist = new ArrayList<Song>();
//        songlist.add(newsong);
        Album inPlaylist = new Album("New Album", "Nathan Moore", "Pop", 2022, songlist);
        // persist CustomPlaylist using persistenceService
        persistenceService.persistPlayList(inPlaylist);
        // retrieve CustomPlaylist from file system by name
        Album outplaylist =(Album) persistenceService.getPlayListByName(playListName);
        // verify the retrieved CustomPlaylist has the same values as the originally stored Playlist
        assert outplaylist.getName().equals(playListName);
        assert outplaylist.getArtist().equals("Nathan Moore");
    }

}
