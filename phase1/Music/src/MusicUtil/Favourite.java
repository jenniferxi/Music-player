package MusicUtil;

import MusicUtil.Playlist;

public class Favourite extends Playlist {
    public Favourite() {
        super();
    }

    @Override
    public boolean add(Integer musicid) {
        super.musics.add(musicid);
        return true;
    }

    @Override
    public boolean remove(Integer musicid) {
        return (super.musics.remove(musicid));
    }

    @Override
    public boolean empty() {
        super.musics.clear();
        return true;
    }

}
