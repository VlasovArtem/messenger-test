package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

/**
 * Created by artemvlasov on 14/07/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    @Modifying
    void deleteByEmail(String email);

}
