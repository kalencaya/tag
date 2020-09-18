package cn.sliew.tag.core.model;

import java.io.Serializable;
import java.util.Map;

public class Tag implements Serializable {

    private Long ruleId;

    private long ruleVersion;

    private Long itemId;

    private long itemVersion;

    private Map<String, String> attachments;

}
