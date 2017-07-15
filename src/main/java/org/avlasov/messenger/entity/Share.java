package org.avlasov.messenger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by artemvlasov on 14/07/2017.
 */
@Entity
@Table(name = "share")
public class Share extends BaseEntity {

    @Column(name = "SHARE_TO", nullable = false, updatable = false, length = 100)
    private String shareTo;

    public Share() {
    }

    public Share(String shareTo) {
        this.shareTo = shareTo;
    }

    public String getShareTo() {
        return shareTo;
    }

    public void setShareTo(String shareTo) {
        this.shareTo = shareTo;
    }
}
