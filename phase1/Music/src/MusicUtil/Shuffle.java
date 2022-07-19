package MusicUtil;

import java.util.Collections;
import java.util.List;

public class Shuffle extends Playlist{

    public Shuffle(List<Integer> currentPlaylist) {

        super();

        Collections.shuffle(currentPlaylist);

        System.out.println(currentPlaylist);
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