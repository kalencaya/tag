package cn.sliew.tag.core.model;

import org.elasticsearch.index.query.QueryBuilder;

import java.io.Serializable;

public interface ConditionCommand extends Serializable {

    QueryBuilder toCondition();
}
