package MusicUtil;

/**
 * A music library
 */

public class Library {
    /**
     * Name of the library
     */
    private String name;
    /**
     * Description of the library
     */
    private String description;

    /**
     * Constructs a music library with initialized name and description
     *
     * @param name name of library
     * @param description description of library
     */
    public Library(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Library() {

    }

    /**
     * Get the name of music library
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of music library
     * @param name the name to be provided
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of music library
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of music library
     * @param description the description to be provided
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
