package org.avlasov.messenger.service;

import org.avlasov.messenger.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 16/07/2017.
 */
public interface UserService {

    Optional<User> save(User user);
    List<User> findByLastName(String lastName);
    List<User> findByFirstName(String firstName);
    Optional<User> findByEmail(String email);
    boolean delete(int id);
    boolean delete(String email);

}
