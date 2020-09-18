package cn.sliew.tag.core.model;

import org.elasticsearch.common.xcontent.FromXContent;
import org.elasticsearch.common.xcontent.ToXContent;

import java.io.Serializable;

public interface ItemCommand extends ToXContent, FromXContent, Serializable {

    Item toItem();
}
