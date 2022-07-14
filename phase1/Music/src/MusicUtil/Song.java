package MusicUtil;

public class Song {
    private String name;
    private String albumName;
    private String artist;
    private String genre;
    private String filepath;
    private Integer id;
    private Integer duration;

    public Song(String name, String albumName, String artist, String genre, String filepath, Integer id){
        this.name = name;
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.filepath = filepath;
        this.id = id;
    }

    public Song(String name){
        this.name=name;
    }

    public String getFilepath(){
        return filepath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
