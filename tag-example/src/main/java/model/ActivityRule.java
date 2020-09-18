package model;

import cn.sliew.tag.core.model.Rule;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.*;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchModule;

import java.io.IOException;
import java.util.Collections;

public class ActivityRule extends Rule {

    private static final long serialVersionUID = 5933436772509715552L;

    public static final String NAME = "ActivityRule";

    private static final ParseField ID_FIELD = new ParseField("ruleId");
    private static final ParseField VERSION_FIELD = new ParseField("ruleVersion");
    private static final ParseField QUERY_FIELD = new ParseField("query");
    private static final ParseField WARMUP_TIME_FIELD = new ParseField("warmupTime");
    private static final ParseField START_TIME_FIELD = new ParseField("startTime");
    private static final ParseField END_TIME_FIELD = new ParseField("endTime");

    private Long ruleId;

    private long ruleVersion;

    private QueryBuilder query;
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

    private static NamedXContentRegistry registry;
    static {
        SearchModule searchModule = new SearchModule(Settings.EMPTY, false, Collections.emptyList());
        registry = new NamedXContentRegistry(searchModule.getNamedXContents());
    }

    private static final ObjectParser<ActivityRule, Void> PARSER = new ObjectParser<>(NAME, ActivityRule::new);
    static {
        PARSER.declareLong(ActivityRule::setRuleId, ActivityRule.ID_FIELD);
        PARSER.declareLong(ActivityRule::setRuleVersion, ActivityRule.VERSION_FIELD);
        PARSER.declareObject(ActivityRule::setQuery, ActivityRule.QUERY_FIELD);

        PARSER.declareLong(ActivityRule::setWarmupTime, ActivityRule.WARMUP_TIME_FIELD);
        PARSER.declareLong(ActivityRule::setStartTime, ActivityRule.START_TIME_FIELD);
        PARSER.declareLong(ActivityRule::setEndTime, ActivityRule.END_TIME_FIELD);
    }

    @Override
    public ActivityRule fromXContent(XContentParser parser) {
        return PARSER.apply(parser, null);
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field(ID_FIELD.getPreferredName(), ruleId);
        builder.field(VERSION_FIELD.getPreferredName(), ruleVersion);
        builder.field(QUERY_FIELD.getPreferredName(), query);
        builder.field(WARMUP_TIME_FIELD.getPreferredName(), warmupTime);
        builder.field(START_TIME_FIELD.getPreferredName(), startTime);
        builder.field(END_TIME_FIELD.getPreferredName(), endTime);
        return builder;
    }

    public static QueryBuilder parse(String query) throws IOException {
        XContentParser parser = JsonXContent.jsonXContent.createParser(registry, LoggingDeprecationHandler.INSTANCE, query);
        return AbstractQueryBuilder.parseInnerQueryBuilder(parser);
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
