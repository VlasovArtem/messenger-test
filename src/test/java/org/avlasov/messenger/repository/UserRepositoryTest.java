package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.User;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
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
        List<User> users = userRepository.findByFirstName("Jon");
        assertFalse(users.isEmpty());
        assertThat(users, IsCollectionContaining.hasItem(getUserMatcher("Jon", "Doe")));
    }

    @Test
    public void findByFirstName_WithNotExistingFirstName_ReturnEmptyOptional() throws Exception {
        List<User> users = userRepository.findByFirstName("not_exists_first_name");
        assertTrue(users.isEmpty());
    }

    @Test
    public void findByLastName_WithExistingLastName_ReturnUserOptional() throws Exception {
        List<User> users = userRepository.findByLastName("Doe");
        assertFalse(users.isEmpty());
        assertThat(users, IsCollectionContaining.hasItem(getUserMatcher("Jane", "Doe")));
    }

    @Test
    public void findByLastName_WithNotExistingLastName_ReturnEmptyOptional() throws Exception {
        List<User> users = userRepository.findByLastName("not_exists_first_name");
        assertTrue(users.isEmpty());
    }

    @Test
    public void findByEmail_WithExistingEmail_ReturnUserOptional() throws Exception {
        Optional<User> user = userRepository.findByEmail("jon-doe@mail.com");
        assertTrue(user.isPresent());
        assertEquals(user.get().getEmail(), "jon-doe@mail.com");
    }

    @Test
    public void findByEmail_WithNotExistingEmail_ReturnEmptyOptional() throws Exception {
        Optional<User> user = userRepository.findByEmail("not-existing@mail.com");
        assertFalse(user.isPresent());
    }

    @Test
    public void existsByEmail_WithExistingEmail_ReturnTrue() throws Exception {
        assertTrue(userRepository.existsByEmail("jane-doe@mail.com"));
    }

    @Test
    public void existsByEmail_WithNotExistingEmail_ReturnFalse() throws Exception {
        assertFalse(userRepository.existsByEmail("not-existing@mail.com"));
    }

    @Test
    public void deleteByEmail_WithExistingEmail() throws Exception {
        long before = userRepository.count();
        userRepository.deleteByEmail("jon-doe@mail.com");
        assertEquals(userRepository.count(), before - 1);
    }

    private UserMatcher getUserMatcher(String firstName, String lastName) {
        return new UserMatcher(firstName, lastName);
    }

    private class UserMatcher extends BaseMatcher<User> {

        private String firstName;
        private String lastName;

        UserMatcher(String firstName, String lastName) {
            Objects.requireNonNull(firstName);
            Objects.requireNonNull(lastName);
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public boolean matches(Object item) {
            if (Objects.nonNull(item)) {
                User user = (User) item;
                return firstName.equals(user.getFirstName()) && lastName.equals(user.getLastName());
            }
            return false;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Matches user first name and last name");
        }
    }

}