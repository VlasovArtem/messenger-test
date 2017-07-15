package org.avlasov.messenger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "COMMENT_TEXT", nullable = false, length = 4000)
    private String commentText;

    public Comment() {
    }

    public Comment(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
