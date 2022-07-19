package MusicUtil;

public class Song {
    private String name;
    private String albumName;
    private String artist;
    private String genre;
    private String filepath;
    private Integer id;
    private Integer duration;

    public Song(String name, String albumName, String artist, String genre, String filepath){
        this.name = name;
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.filepath = filepath;
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

    public String getArtist(){
        return artist;
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

    public String artistTitleAlbum(){
        return artist + " - " + name + " (" + albumName + ")";
    }
}
