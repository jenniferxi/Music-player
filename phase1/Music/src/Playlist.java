import java.util.ArrayList;
import java.util.List;

public abstract class Playlist {
    protected List<Integer> musics;
    private String name;

    public Playlist(String name) {
        this.musics = new ArrayList<>();
        this.name = name;
    }

    public Playlist() {
        this.musics = new ArrayList<>();
    }


    public abstract boolean add(Integer musicid);


    public abstract boolean remove(Integer musicid);

    public abstract boolean empty();

    public List content() {
        return musics;
    }

}
