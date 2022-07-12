package MusicUtil;

import MusicUtil.Playlist;

import java.util.List;

public class History extends Playlist {

    public History() {
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

    @Override
    public boolean isSharable() {
        return false;
    }

    @Override
    public List getMusics() {
        return super.musics;
    }
}
