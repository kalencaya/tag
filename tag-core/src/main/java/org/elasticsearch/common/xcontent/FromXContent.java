package org.elasticsearch.common.xcontent;

public interface FromXContent {

    <T> T fromXContent(XContentParser parser);
}
