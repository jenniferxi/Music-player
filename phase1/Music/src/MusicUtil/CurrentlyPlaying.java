package MusicUtil;

import java.util.List;

public class CurrentlyPlaying extends Playlist {
    public CurrentlyPlaying(Integer musicid) {
        super();
        super.musics.add(musicid);
    }

    public CurrentlyPlaying(Playlist p) {
        super();
        super.musics.addAll(p.musics);
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
        return false;
    }

    @Override
    public List getMusics() {
        return super.musics;
    }
}
