package org.avlasov.messenger.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Entity
@Table(name = "message")
public class Message extends BaseEntity {

    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "BODY", nullable = false, length = 5000)
    private String body;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MESSAGE_ID")
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MESSAGE_ID")
    private List<Like> likes;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MESSAGE_ID")
    private List<Share> shares;

    public Message(String title, String body, List<Comment> comments, List<Like> likes, List<Share> shares) {
        this.title = title;
        this.body = body;
        this.comments = comments;
        this.likes = likes;
        this.shares = shares;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }
}
