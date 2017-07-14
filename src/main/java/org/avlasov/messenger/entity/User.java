package org.avlasov.messenger.entity;

import org.avlasov.messenger.enums.Sex;

import javax.persistence.*;
import java.util.List;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "FIRST_NAME", length = 30)
    private String firstName;
    @Column(name = "LAST_NAME", length = 40)
    private String lastName;
    @Column(name = "EMAIL", length = 40, nullable = false, unique = true)
    private String email;
    @Column(name = "SEX", length = 10)
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<Message> messages;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<Like> likes;

    public User(String firstName, String lastName, String email, Sex sex, List<Message> messages, List<Comment> comments, List<Like> likes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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
