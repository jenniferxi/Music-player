package MusicUtil;

public class Library {
    private String name;
    private String description;

    public Library(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Library() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
