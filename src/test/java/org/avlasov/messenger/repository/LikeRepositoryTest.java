package org.avlasov.messenger.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public class LikeRepositoryTest extends MainRepositoryTest {

    @Autowired
    private LikeRepository likeRepository;

    @Test
    public void countMessageLikes_WithExistingMessageId_ReturnLong() throws Exception {
        long likes = likeRepository.countMessageLikes(2);
        assertEquals(likes, 2);
    }

    @Test
    public void countMessageLikes_WithNotExistingMessageId_ReturnLong() throws Exception {
        long likes = likeRepository.countMessageLikes(999);
        assertEquals(likes, 0);
    }

    @Test
    public void countUserLikes_WithExistingUserId_ReturnLong() throws Exception {
        long likes = likeRepository.countUserLikes(1);
        assertEquals(likes, 1);
    }

    @Test
    public void countUserLikes_WithNotExistingUserId_ReturnLong() throws Exception {
        long likes = likeRepository.countUserLikes(999);
        assertEquals(likes, 0);
    }

}