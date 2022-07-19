package MusicUtil;

import java.util.List;

public class CurrentlyPlaying extends Playlist {
    public CurrentlyPlaying(Song musicid) {
        super();
        super.musics.add(musicid);
    }

    public CurrentlyPlaying(Playlist p) {
        super();
        super.musics.addAll(p.musics);
    }

    @Override
    public boolean add(List<Song> songs) {
        super.musics.addAll(songs);
        return true;
    }

    @Override
    public boolean remove(Song musicid) {
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
    public List<Song> getMusics() {
        return super.musics;
    }
}
