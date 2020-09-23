package cn.sliew.tag.example.model;

import cn.sliew.tag.core.model.Item;
import cn.sliew.tag.core.model.RuleCommand;
import cn.sliew.tag.core.model.Tag;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.*;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchModule;

import java.io.IOException;
import java.util.Collections;

public class ActivityRuleCommand implements RuleCommand {

    private static final long serialVersionUID = 4032105597360982440L;

    public static final String NAME = "ActivityRuleCommand";

    private static final ParseField ID_FIELD = new ParseField("ruleId");
    private static final ParseField VERSION_FIELD = new ParseField("ruleVersion");
    private static final ParseField QUERY_FIELD = new ParseField("query");
    private static final ParseField CONDITION_FIELD = new ParseField("conditon");
    private static final ParseField TAG_EXT_FIELD = new ParseField("tagExt");
    private static final ParseField WARMUP_TIME_FIELD = new ParseField("warmupTime");
    private static final ParseField START_TIME_FIELD = new ParseField("startTime");
    private static final ParseField END_TIME_FIELD = new ParseField("endTime");

    private Long ruleId;

    private long ruleVersion;

    private QueryBuilder query;

    private QueryBuilder conditon;

    private String tagExt;
    /**
     * unit: millseconds
     */
    private Long warmupTime;
    /**
     * unit: millseconds
     */
    private Long startTime;
    /**
     * unit: millseconds
     */
    private Long endTime;


    @Override
    public QueryBuilder toQuery() {
        return query;
    }

    @Override
    public QueryBuilder toCondition() {
        return conditon;
    }

    private static NamedXContentRegistry registry;
    static {
        SearchModule searchModule = new SearchModule(Settings.EMPTY, false, Collections.emptyList());
        registry = new NamedXContentRegistry(searchModule.getNamedXContents());
    }

    private static final ObjectParser<ActivityRuleCommand, Void> PARSER = new ObjectParser<>(NAME, ActivityRuleCommand::new);
    static {
        PARSER.declareLong(ActivityRuleCommand::setRuleId, ActivityRuleCommand.ID_FIELD);
        PARSER.declareLong(ActivityRuleCommand::setRuleVersion, ActivityRuleCommand.VERSION_FIELD);
        PARSER.declareField(ActivityRuleCommand::setQuery,
                parser -> AbstractQueryBuilder.parseInnerQueryBuilder(parser),
                ActivityRuleCommand.QUERY_FIELD, ObjectParser.ValueType.OBJECT);
        PARSER.declareField(ActivityRuleCommand::setConditon,
                parser -> AbstractQueryBuilder.parseInnerQueryBuilder(parser),
                ActivityRuleCommand.CONDITION_FIELD, ObjectParser.ValueType.OBJECT);
        PARSER.declareString(ActivityRuleCommand::setTagExt, ActivityRuleCommand.TAG_EXT_FIELD);
        PARSER.declareLong(ActivityRuleCommand::setWarmupTime, ActivityRuleCommand.WARMUP_TIME_FIELD);
        PARSER.declareLong(ActivityRuleCommand::setStartTime, ActivityRuleCommand.START_TIME_FIELD);
        PARSER.declareLong(ActivityRuleCommand::setEndTime, ActivityRuleCommand.END_TIME_FIELD);
    }

    @Override
    public ActivityRuleCommand fromXContent(String xcontent) throws IOException {
        XContentParser parser = JsonXContent.jsonXContent.createParser(registry, LoggingDeprecationHandler.INSTANCE, xcontent);
        return PARSER.apply(parser, null);
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject();
        builder.field(ID_FIELD.getPreferredName(), ruleId);
        builder.field(VERSION_FIELD.getPreferredName(), ruleVersion);
        builder.field(QUERY_FIELD.getPreferredName(), query);
        builder.field(CONDITION_FIELD.getPreferredName(), conditon);
        builder.field(TAG_EXT_FIELD.getPreferredName(), tagExt);
        builder.field(WARMUP_TIME_FIELD.getPreferredName(), warmupTime);
        builder.field(START_TIME_FIELD.getPreferredName(), startTime);
        builder.field(END_TIME_FIELD.getPreferredName(), endTime);
        builder.endObject();
        return builder;
    }

    /* ======================== getter/setter ======================== */

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public long getRuleVersion() {
        return ruleVersion;
    }

    public void setRuleVersion(long ruleVersion) {
        this.ruleVersion = ruleVersion;
    }

    public QueryBuilder getQuery() {
        return query;
    }

    public void setQuery(QueryBuilder query) {
        this.query = query;
    }

    public QueryBuilder getConditon() {
        return conditon;
    }

    public void setConditon(QueryBuilder conditon) {
        this.conditon = conditon;
    }

    public String getTagExt() {
        return tagExt;
    }

    public void setTagExt(String tagExt) {
        this.tagExt = tagExt;
    }

    public Long getWarmupTime() {
        return warmupTime;
    }

    public void setWarmupTime(Long warmupTime) {
        this.warmupTime = warmupTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
