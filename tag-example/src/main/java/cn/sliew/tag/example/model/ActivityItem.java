package cn.sliew.tag.example.model;

import cn.sliew.tag.core.model.Item;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.xcontent.*;
import org.elasticsearch.common.xcontent.json.JsonXContent;

import java.io.IOException;
import java.util.Random;

public class ActivityItem extends Item {

    private static final long serialVersionUID = 7681245479744613313L;

    public static final String NAME = "ActivityItem";

    private static final ParseField ID_FIELD = new ParseField("itemId");
    private static final ParseField VERSION_FIELD = new ParseField("itemVersion");
    private static final ParseField CATEGORY_ID_FIELD = new ParseField("categoryId");
    private static final ParseField SHOP_ID_FIELD = new ParseField("shopId");

    private Long itemId;

    private long itemVersion;

    private Long categoryId;

    private Long shopId;

    private static final ObjectParser<ActivityItem, Void> PARSER = new ObjectParser<>(NAME, ActivityItem::new);
    static {
        PARSER.declareLong(ActivityItem::setItemId, ActivityItem.ID_FIELD);
        PARSER.declareLong(ActivityItem::setItemVersion, ActivityItem.VERSION_FIELD);
        PARSER.declareLong(ActivityItem::setCategoryId, ActivityItem.CATEGORY_ID_FIELD);
        PARSER.declareLong(ActivityItem::setShopId, ActivityItem.SHOP_ID_FIELD);
    }

    @Override
    public ActivityItem fromXContent(String xcontent) throws IOException {
        XContentParser parser = JsonXContent.jsonXContent.createParser(null, LoggingDeprecationHandler.INSTANCE, xcontent);
        return PARSER.apply(parser, null);
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject();
            builder.field(ActivityItem.ID_FIELD.getPreferredName(), itemId);
            builder.field(ActivityItem.VERSION_FIELD.getPreferredName(), itemVersion);
            builder.field(ActivityItem.CATEGORY_ID_FIELD.getPreferredName(), categoryId);
            builder.field(ActivityItem.SHOP_ID_FIELD.getPreferredName(), shopId);
        builder.endObject();
        return builder;
    }

    public static void main(String[] args) throws IOException {
        ActivityItem item = new ActivityItem();
        Random random = new Random();
        item.setItemId(random.nextLong());
        item.setItemVersion(random.nextLong());
        item.setCategoryId(random.nextLong());
        item.setShopId(random.nextLong());
        XContentBuilder builder = item.toXContent(XContentFactory.jsonBuilder(), EMPTY_PARAMS);
        String string = BytesReference.bytes(builder).utf8ToString();
        ActivityItem item1 = item.fromXContent(string);
        System.out.println(item1);
    }

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ActivityItem{" +
                "itemId=" + itemId +
                ", itemVersion=" + itemVersion +
                ", categoryId=" + categoryId +
                ", shopId=" + shopId +
                '}';
    }
}
