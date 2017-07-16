package org.avlasov.messenger.repository;

import org.avlasov.messenger.MessengerBaseMatcher;
import org.avlasov.messenger.entity.Share;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public class ShareRepositoryTest extends MainRepositoryTest {

    @Autowired
    private ShareRepository shareRepository;

    @Test
    public void findMessageShares_WithExistingMessageId_ReturnSharesCollection() throws Exception {
        List<Share> shares = shareRepository.findMessageShares(1);
        assertThat(shares, IsCollectionWithSize.hasSize(1));
        assertThat(shares, IsCollectionContaining.hasItem(
                getMatcher("https://twitter.com")));
    }

    @Test
    public void findMessageShares_WithNotExistingMessageId_ReturnEmptyCollection() throws Exception {
        List<Share> shares = shareRepository.findMessageShares(999);
        assertThat(shares, IsEmptyCollection.empty());
    }

    @Test
    public void countMessageShares_WithExistingMessageId_ReturnLong() throws Exception {
        long shares = shareRepository.countMessageShares(2);
        assertEquals(shares, 1);
    }

    @Test
    public void countMessageShares_WithNotExistingMessageId_ReturnLong() throws Exception {
        long shares = shareRepository.countMessageShares(999);
        assertEquals(shares, 0);
    }

    private Matcher<Share> getMatcher(String shareTo) {
        return new MessengerBaseMatcher<>(share -> shareTo.equals(share.getShareTo()));
    }

}