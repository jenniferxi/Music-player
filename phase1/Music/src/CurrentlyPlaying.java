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
