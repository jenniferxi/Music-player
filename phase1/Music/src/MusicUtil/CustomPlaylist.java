package MusicUtil;

import MusicUtil.Playlist;

import java.util.List;

public class CustomPlaylist extends Playlist {
    public CustomPlaylist(String name) {
        super(name);
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
        return true;
    }

    @Override
    public List getMusics() {
        return null;
    }
}
