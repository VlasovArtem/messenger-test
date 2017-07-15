package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Comment;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public class CommentRepositoryTest extends MainRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void findMessageComments_WithExistingMessageId_ReturnCommentsCollection() throws Exception {
        List<Comment> comments = commentRepository.findMessageComments(1);
        assertFalse(comments.isEmpty());
        assertThat(comments, IsCollectionWithSize.hasSize(1));
        assertThat(comments, IsCollectionContaining.hasItem(getCommentTextMatcher("Hello Jon")));
    }

    @Test
    public void findMessageComments_WithNotExistingMessageId_ReturnEmptyCollection() throws Exception {
        List<Comment> comments = commentRepository.findMessageComments(999);
        assertTrue(comments.isEmpty());
    }

    @Test
    public void findUserComments_WithExistingUserId_ReturnCommentsCollection() throws Exception {
        List<Comment> comments = commentRepository.findUserComments(1);
        assertFalse(comments.isEmpty());
        assertThat(comments, IsCollectionWithSize.hasSize(1));
        assertThat(comments, IsCollectionContaining.hasItem(getCommentTextMatcher("Hello Jane")));
    }

    @Test
    public void findUserComments_WithNotExistingUserId_ReturnEmptyCollection() throws Exception {
        List<Comment> comments = commentRepository.findUserComments(999);
        assertTrue(comments.isEmpty());
    }

    private CommentTextMatcher getCommentTextMatcher(String commentText) {
        return new CommentTextMatcher(commentText);
    }

    private class CommentTextMatcher extends BaseMatcher<Comment> {

        private String commentText;

        CommentTextMatcher(String commentText) {
            Objects.requireNonNull(commentText);
            this.commentText = commentText;
        }

        @Override
        public boolean matches(Object item) {
            if (Objects.nonNull(item)) {
                Comment comment = (Comment) item;
                return commentText.equals(comment.getCommentText());
            }
            return false;
        }

        @Override
        public void describeTo(Description description) {

        }
    }


}