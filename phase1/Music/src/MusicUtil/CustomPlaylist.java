package MusicUtil;

import java.util.List;

import java.util.List;

public class CustomPlaylist extends Playlist {
    private boolean sharable;
    public final String Owner;

    public CustomPlaylist(String name, String Owner) {
        super(name);
        this.sharable = false;
        this.Owner = Owner;
    }

    @Override
    public boolean add(List<Integer> songs) {
        super.musics.addAll(songs);
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
        return sharable;
    }

    @Override
    public List getMusics() {
        return super.musics;
    }
}
