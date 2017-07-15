package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    Optional<Message> findByTitle(String title);
    List<Message> findByTitleContaining(String title);
    List<Message> findByBodyContaining(String body);
    @Query("SELECT u.messages FROM User u WHERE u.id = ?1")
    List<Message> findAuthorMessages(int authorId);
    boolean existsByTitle(String title);

}
