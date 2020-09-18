package cn.sliew.tag.example.command;

import cn.sliew.tag.core.model.Item;
import cn.sliew.tag.core.model.RuleCommand;
import cn.sliew.tag.core.model.Tag;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.index.query.QueryBuilder;

import java.io.IOException;

public class ActivityRuleCommand implements RuleCommand {

    private static final long serialVersionUID = 4032105597360982440L;

    @Override
    public QueryBuilder toQuery() {
        return null;
    }

    @Override
    public Tag toTag(Item item) {
        return null;
    }

    @Override
    public QueryBuilder toCondition() {
        return null;
    }

    @Override
    public ActivityRuleCommand fromXContent(XContentParser parser) {
        return null;
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return null;
    }
}
