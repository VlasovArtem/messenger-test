package org.avlasov.messenger.entity;

/**
 * Created by artemvlasov on 14/07/2017.
 */
public class Share extends BaseEntity {

    private String shareTo;

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
