package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Comment;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public class CommentRepositoryTest extends MainRepositoryTest<Comment> {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void findMessageComments_WithExistingMessageId_ReturnCommentsCollection() throws Exception {
        List<Comment> comments = commentRepository.findMessageComments(1);
        assertFalse(comments.isEmpty());
        assertThat(comments, IsCollectionWithSize.hasSize(1));
        assertThat(comments, IsCollectionContaining.hasItem(getMatcher("Hello Jon")));
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
        assertThat(comments, IsCollectionContaining.hasItem(getMatcher("Hello Jane")));
    }

    @Test
    public void findUserComments_WithNotExistingUserId_ReturnEmptyCollection() throws Exception {
        List<Comment> comments = commentRepository.findUserComments(999);
        assertTrue(comments.isEmpty());
    }

    private Matcher<Comment> getMatcher(String commentText) {
        return getMessengerBaseMatcher(comment -> commentText.equals(comment.getCommentText()));
    }



}