package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by artemvlasov on 14/07/2017.
 */
public class UserRepositoryTest extends MainRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByFirstName_WithExistingFirstName_ReturnUserOptional() throws Exception {
        Optional<User> user = userRepository.findByFirstName("test_first_name");
        assertTrue(user.isPresent());
        assertEquals(user.get().getFirstName(), "test_first_name");
    }

    @Test
    public void findByFirstName_WithNotExistingFirstName_ReturnEmptyOptional() throws Exception {
        Optional<User> user = userRepository.findByFirstName("not_exists_first_name");
        assertFalse(user.isPresent());
    }

    @Test
    public void findByLastName_WithExistingLastName_ReturnUserOptional() throws Exception {
        Optional<User> user = userRepository.findByLastName("test_last_name");
        assertTrue(user.isPresent());
        assertEquals(user.get().getLastName(), "test_last_name");
    }

    @Test
    public void findByLastName_WithNotExistingLastName_ReturnEmptyOptional() throws Exception {
        Optional<User> user = userRepository.findByLastName("not_existing_last_name");
        assertFalse(user.isPresent());
    }

    @Test
    public void findByEmail_WithExistingEmail_ReturnUserOptional() throws Exception {
        Optional<User> user = userRepository.findByEmail("test@mail.com");
        assertTrue(user.isPresent());
        assertEquals(user.get().getEmail(), "test@mail.com");
    }

    @Test
    public void findByEmail_WithNotExistingEmail_ReturnEmptyOptional() throws Exception {
        Optional<User> user = userRepository.findByEmail("not-existing@mail.com");
        assertFalse(user.isPresent());
    }

    @Test
    public void existsByEmail_WithExistingEmail_ReturnTrue() throws Exception {
        assertTrue(userRepository.existsByEmail("test@mail.com"));
    }

    @Test
    public void existsByEmail_WithNotExistingEmail_ReturnFalse() throws Exception {
        assertFalse(userRepository.existsByEmail("not-existing@mail.com"));
    }

    @Test
    public void deleteByEmail_WithExistingEmail() throws Exception {
        long before = userRepository.count();
        userRepository.deleteByEmail("test@mail.com");
        assertEquals(userRepository.count(), before - 1);
    }

}