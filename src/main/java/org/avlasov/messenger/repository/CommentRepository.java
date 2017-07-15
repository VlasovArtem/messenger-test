package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT m.comments FROM Message m WHERE m.id = ?1")
    List<Comment> findMessageComments(int messageId);
    @Query("SELECT u.comments FROM User u WHERE u.id = ?1")
    List<Comment> findUserComments(int userId);

}
