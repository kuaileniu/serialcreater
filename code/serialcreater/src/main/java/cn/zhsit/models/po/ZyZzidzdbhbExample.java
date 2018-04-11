package cn.zhsit.models.po;

import java.util.ArrayList;
import java.util.List;

public class ZyZzidzdbhbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyZzidzdbhbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * zy_zzidzdbhb 
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andVZzlbIsNull() {
            addCriterion("v_zzlb is null");
            return (Criteria) this;
        }

        public Criteria andVZzlbIsNotNull() {
            addCriterion("v_zzlb is not null");
            return (Criteria) this;
        }

        public Criteria andVZzlbEqualTo(String value) {
            addCriterion("v_zzlb =", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbNotEqualTo(String value) {
            addCriterion("v_zzlb <>", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbGreaterThan(String value) {
            addCriterion("v_zzlb >", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbGreaterThanOrEqualTo(String value) {
            addCriterion("v_zzlb >=", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbLessThan(String value) {
            addCriterion("v_zzlb <", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbLessThanOrEqualTo(String value) {
            addCriterion("v_zzlb <=", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbLike(String value) {
            addCriterion("v_zzlb like", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbNotLike(String value) {
            addCriterion("v_zzlb not like", value, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbIn(List<String> values) {
            addCriterion("v_zzlb in", values, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbNotIn(List<String> values) {
            addCriterion("v_zzlb not in", values, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbBetween(String value1, String value2) {
            addCriterion("v_zzlb between", value1, value2, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVZzlbNotBetween(String value1, String value2) {
            addCriterion("v_zzlb not between", value1, value2, "vZzlb");
            return (Criteria) this;
        }

        public Criteria andVQshIsNull() {
            addCriterion("v_qsh is null");
            return (Criteria) this;
        }

        public Criteria andVQshIsNotNull() {
            addCriterion("v_qsh is not null");
            return (Criteria) this;
        }

        public Criteria andVQshEqualTo(String value) {
            addCriterion("v_qsh =", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshNotEqualTo(String value) {
            addCriterion("v_qsh <>", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshGreaterThan(String value) {
            addCriterion("v_qsh >", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshGreaterThanOrEqualTo(String value) {
            addCriterion("v_qsh >=", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshLessThan(String value) {
            addCriterion("v_qsh <", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshLessThanOrEqualTo(String value) {
            addCriterion("v_qsh <=", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshLike(String value) {
            addCriterion("v_qsh like", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshNotLike(String value) {
            addCriterion("v_qsh not like", value, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshIn(List<String> values) {
            addCriterion("v_qsh in", values, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshNotIn(List<String> values) {
            addCriterion("v_qsh not in", values, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshBetween(String value1, String value2) {
            addCriterion("v_qsh between", value1, value2, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVQshNotBetween(String value1, String value2) {
            addCriterion("v_qsh not between", value1, value2, "vQsh");
            return (Criteria) this;
        }

        public Criteria andVDqhIsNull() {
            addCriterion("v_dqh is null");
            return (Criteria) this;
        }

        public Criteria andVDqhIsNotNull() {
            addCriterion("v_dqh is not null");
            return (Criteria) this;
        }

        public Criteria andVDqhEqualTo(String value) {
            addCriterion("v_dqh =", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhNotEqualTo(String value) {
            addCriterion("v_dqh <>", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhGreaterThan(String value) {
            addCriterion("v_dqh >", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhGreaterThanOrEqualTo(String value) {
            addCriterion("v_dqh >=", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhLessThan(String value) {
            addCriterion("v_dqh <", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhLessThanOrEqualTo(String value) {
            addCriterion("v_dqh <=", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhLike(String value) {
            addCriterion("v_dqh like", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhNotLike(String value) {
            addCriterion("v_dqh not like", value, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhIn(List<String> values) {
            addCriterion("v_dqh in", values, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhNotIn(List<String> values) {
            addCriterion("v_dqh not in", values, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhBetween(String value1, String value2) {
            addCriterion("v_dqh between", value1, value2, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVDqhNotBetween(String value1, String value2) {
            addCriterion("v_dqh not between", value1, value2, "vDqh");
            return (Criteria) this;
        }

        public Criteria andVJzhIsNull() {
            addCriterion("v_jzh is null");
            return (Criteria) this;
        }

        public Criteria andVJzhIsNotNull() {
            addCriterion("v_jzh is not null");
            return (Criteria) this;
        }

        public Criteria andVJzhEqualTo(String value) {
            addCriterion("v_jzh =", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhNotEqualTo(String value) {
            addCriterion("v_jzh <>", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhGreaterThan(String value) {
            addCriterion("v_jzh >", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhGreaterThanOrEqualTo(String value) {
            addCriterion("v_jzh >=", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhLessThan(String value) {
            addCriterion("v_jzh <", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhLessThanOrEqualTo(String value) {
            addCriterion("v_jzh <=", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhLike(String value) {
            addCriterion("v_jzh like", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhNotLike(String value) {
            addCriterion("v_jzh not like", value, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhIn(List<String> values) {
            addCriterion("v_jzh in", values, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhNotIn(List<String> values) {
            addCriterion("v_jzh not in", values, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhBetween(String value1, String value2) {
            addCriterion("v_jzh between", value1, value2, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVJzhNotBetween(String value1, String value2) {
            addCriterion("v_jzh not between", value1, value2, "vJzh");
            return (Criteria) this;
        }

        public Criteria andVBzIsNull() {
            addCriterion("v_bz is null");
            return (Criteria) this;
        }

        public Criteria andVBzIsNotNull() {
            addCriterion("v_bz is not null");
            return (Criteria) this;
        }

        public Criteria andVBzEqualTo(String value) {
            addCriterion("v_bz =", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzNotEqualTo(String value) {
            addCriterion("v_bz <>", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzGreaterThan(String value) {
            addCriterion("v_bz >", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzGreaterThanOrEqualTo(String value) {
            addCriterion("v_bz >=", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzLessThan(String value) {
            addCriterion("v_bz <", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzLessThanOrEqualTo(String value) {
            addCriterion("v_bz <=", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzLike(String value) {
            addCriterion("v_bz like", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzNotLike(String value) {
            addCriterion("v_bz not like", value, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzIn(List<String> values) {
            addCriterion("v_bz in", values, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzNotIn(List<String> values) {
            addCriterion("v_bz not in", values, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzBetween(String value1, String value2) {
            addCriterion("v_bz between", value1, value2, "vBz");
            return (Criteria) this;
        }

        public Criteria andVBzNotBetween(String value1, String value2) {
            addCriterion("v_bz not between", value1, value2, "vBz");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * zy_zzidzdbhb 
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}