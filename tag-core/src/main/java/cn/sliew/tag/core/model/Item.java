package cn.sliew.tag.core.model;

import org.elasticsearch.common.xcontent.FromXContent;
import org.elasticsearch.common.xcontent.ToXContent;

import java.io.Serializable;

public abstract class Item implements ToXContent, FromXContent, Serializable {

    private Long itemId;

    private long itemVersion;



    /* ======================== getter/setter ======================== */

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public long getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(long itemVersion) {
        this.itemVersion = itemVersion;
    }
}
