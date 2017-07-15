package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public interface LikeRepository extends JpaRepository<Like, Integer> {

    @Query("SELECT count(l) FROM Message m JOIN m.likes l WHERE m.id = ?1")
    long countMessageLikes(int messageId);
    @Query("SELECT count(l) FROM User u JOIN u.likes l WHERE u.id = ?1")
    long countUserLikes(int userId);


}
