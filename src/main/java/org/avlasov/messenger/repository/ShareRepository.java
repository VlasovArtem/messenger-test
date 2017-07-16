package org.avlasov.messenger.repository;

import org.avlasov.messenger.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by artemvlasov on 15/07/2017.
 */
public interface ShareRepository extends JpaRepository<Share, Integer> {

    @Query("SELECT m.shares FROM Message m WHERE m.id = ?1")
    List<Share> findMessageShares(int messageId);
    @Query("SELECT count(s) FROM Message m JOIN m.shares s WHERE m.id = ?1")
    long countMessageShares(int messageId);

}
