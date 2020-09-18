package cn.sliew.tag.core.model;

import java.io.Serializable;

public interface TagCommand extends Serializable {

    Tag toTag(Rule rule, Item item);
}
