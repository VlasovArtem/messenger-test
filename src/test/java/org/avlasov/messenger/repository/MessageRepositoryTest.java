package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Message;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public class MessageRepositoryTest extends MainRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void findByTitle_WithExistingTitle_ReturnMessageOptional() throws Exception {
        Optional<Message> message = messageRepository.findByTitle("Message to Jane Doe");
        assertTrue(message.isPresent());
    }

    @Test
    public void findByTitle_WithNotExistingTitle_ReturnEmptyOptional() throws Exception {
        Optional<Message> message = messageRepository.findByTitle("Missing title");
        assertFalse(message.isPresent());
    }

    @Test
    public void findByTitleContaining_WithMatchingTitle_ReturnMessagesCollection() throws Exception {
        List<Message> messages = messageRepository.findByTitleContaining("Message");
        assertFalse(messages.isEmpty());
        assertThat(messages, IsCollectionWithSize.hasSize(2));
    }

    @Test
    public void findByTitleContaining_WithNotMatchingTitle_ReturnEmptyCollection() throws Exception {
        List<Message> messages = messageRepository.findByTitleContaining("Test");
        assertTrue(messages.isEmpty());
    }

    @Test
    public void findByBodyContaining_WithMatchingBody_ReturnMessagesCollection() throws Exception {
        List<Message> messages = messageRepository.findByBodyContaining("Jane Doe");
        assertFalse(messages.isEmpty());
        assertThat(messages, IsCollectionWithSize.hasSize(1));
    }

    @Test
    public void findByBodyContaining_WithNotMatchingBody_ReturnEmptyCollection() throws Exception {
        List<Message> messages = messageRepository.findByBodyContaining("Test");
        assertTrue(messages.isEmpty());
    }

    @Test
    public void findAuthorMessages_WithExistingAuthorId_ReturnMessagesCollection() throws Exception {
        List<Message> authorMessages = messageRepository.findAuthorMessages(1);
        assertThat(authorMessages, IsCollectionWithSize.hasSize(1));
    }

    @Test
    public void findAuthorMessages_WithNotExistingAuthorId_ReturnEmptyCollection() throws Exception {
        List<Message> authorMessages = messageRepository.findAuthorMessages(999);
        assertThat(authorMessages, IsCollectionWithSize.hasSize(0));
    }

    @Test
    public void existsByTitle_WithExistingTitle_ReturnTrue() throws Exception {
        assertTrue(messageRepository.existsByTitle("Message to Jon Doe"));
    }

    @Test
    public void existsByTitle_WithNotExistingTitle_ReturnFalse() throws Exception {
        assertFalse(messageRepository.existsByTitle("TEST"));
    }

}