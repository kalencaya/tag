package org.elasticsearch.common.xcontent;

import java.io.IOException;

public interface FromXContent {

    <T> T fromXContent(String xcontent) throws IOException;
}
