package org.avlasov.messenger.entity;

import java.util.List;

/**
 * Created by artemvlasov on 14/07/2017.
 */
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private List<Message> messages;
    private List<Comment> comments;
    private List<Like> likes;

    public User(String firstName, String lastName, String email, List<Message> messages, List<Comment> comments, List<Like> likes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.messages = messages;
        this.comments = comments;
        this.likes = likes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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
}
