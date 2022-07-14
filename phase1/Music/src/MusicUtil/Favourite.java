package MusicUtil;

import java.util.ArrayList;
import java.util.List;

public class Favourite extends Playlist {
    private boolean sharable;
    public final String owner;
    private List<String> recipients;

    public Favourite(String owner) {
        super();
        this.sharable = false;
        this.owner = owner;
        this.recipients = new ArrayList<>();
    }

    public void setSharable(boolean sharable) {
        this.sharable = sharable;
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
        return this.sharable;
    }

    @Override
    public List getMusics() {
        if (sharable) {
            return super.musics;
        }
        return null;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    public boolean removeRecipient(String recipient) {
        return recipients.remove(recipient);
    }
}
