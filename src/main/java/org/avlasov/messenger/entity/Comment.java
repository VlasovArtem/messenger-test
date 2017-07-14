package org.avlasov.messenger.entity;

/**
 * Created by artemvlasov on 14/07/2017.
 */
public class Comment extends BaseEntity {

    private String commentText;

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
