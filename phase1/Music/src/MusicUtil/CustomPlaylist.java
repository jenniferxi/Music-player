package MusicUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomPlaylist extends Playlist {
    private boolean sharable;
    public final String Owner;
    private List<String> recipients;

    public CustomPlaylist(String name, String Owner) {
        super(name);
        this.sharable = false;
        this.Owner = Owner;
        this.recipients = new ArrayList<>();
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
        return sharable;
    }

    public void setSharable(boolean sharable) {
        this.sharable = sharable;
    }

    @Override
    public List getMusics() {
        return super.musics;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void addRecipient(String recipient) {
        if (!recipients.contains(recipient)) {
            recipients.add(recipient);
        }
    }

    public boolean removeRecipient(String recipient) {
        if (recipient.contains(recipient)) {
            return recipients.remove(recipient);
        }
        return false;
    }
}
