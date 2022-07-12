package MusicUtil;

import MusicUtil.Playlist;

import java.util.List;

public class Favourite extends Playlist {
    private boolean sharable;

    public Favourite() {
        super();
        this.sharable = false;
    }

    public void setSharable(boolean sharable) {
        this.sharable = sharable;
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

    @Override
    public boolean isSharable() {
        return this.sharable;
    }

    @Override
    public List getMusics() {
        if (sharable) {
            return super.musics;
        }
        return null;
    }
}
