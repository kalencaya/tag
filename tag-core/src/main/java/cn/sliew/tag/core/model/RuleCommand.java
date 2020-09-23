package cn.sliew.tag.core.model;

import org.elasticsearch.common.xcontent.FromXContent;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.index.query.QueryBuilder;

import java.io.Serializable;

public interface RuleCommand extends ConditionCommand, ToXContent, FromXContent, Serializable {

    QueryBuilder toQuery();
}
