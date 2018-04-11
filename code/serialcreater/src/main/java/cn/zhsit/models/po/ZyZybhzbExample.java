package cn.zhsit.models.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZyZybhzbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyZybhzbExample() {
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
     * zy_zybhzb 
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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(String value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(String value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(String value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(String value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(String value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(String value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLike(String value) {
            addCriterion("v_id like", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotLike(String value) {
            addCriterion("v_id not like", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<String> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<String> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(String value1, String value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(String value1, String value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVCplbIsNull() {
            addCriterion("v_cplb is null");
            return (Criteria) this;
        }

        public Criteria andVCplbIsNotNull() {
            addCriterion("v_cplb is not null");
            return (Criteria) this;
        }

        public Criteria andVCplbEqualTo(String value) {
            addCriterion("v_cplb =", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbNotEqualTo(String value) {
            addCriterion("v_cplb <>", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbGreaterThan(String value) {
            addCriterion("v_cplb >", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbGreaterThanOrEqualTo(String value) {
            addCriterion("v_cplb >=", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbLessThan(String value) {
            addCriterion("v_cplb <", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbLessThanOrEqualTo(String value) {
            addCriterion("v_cplb <=", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbLike(String value) {
            addCriterion("v_cplb like", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbNotLike(String value) {
            addCriterion("v_cplb not like", value, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbIn(List<String> values) {
            addCriterion("v_cplb in", values, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbNotIn(List<String> values) {
            addCriterion("v_cplb not in", values, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbBetween(String value1, String value2) {
            addCriterion("v_cplb between", value1, value2, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVCplbNotBetween(String value1, String value2) {
            addCriterion("v_cplb not between", value1, value2, "vCplb");
            return (Criteria) this;
        }

        public Criteria andVZyidIsNull() {
            addCriterion("v_zyid is null");
            return (Criteria) this;
        }

        public Criteria andVZyidIsNotNull() {
            addCriterion("v_zyid is not null");
            return (Criteria) this;
        }

        public Criteria andVZyidEqualTo(String value) {
            addCriterion("v_zyid =", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidNotEqualTo(String value) {
            addCriterion("v_zyid <>", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidGreaterThan(String value) {
            addCriterion("v_zyid >", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidGreaterThanOrEqualTo(String value) {
            addCriterion("v_zyid >=", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidLessThan(String value) {
            addCriterion("v_zyid <", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidLessThanOrEqualTo(String value) {
            addCriterion("v_zyid <=", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidLike(String value) {
            addCriterion("v_zyid like", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidNotLike(String value) {
            addCriterion("v_zyid not like", value, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidIn(List<String> values) {
            addCriterion("v_zyid in", values, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidNotIn(List<String> values) {
            addCriterion("v_zyid not in", values, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidBetween(String value1, String value2) {
            addCriterion("v_zyid between", value1, value2, "vZyid");
            return (Criteria) this;
        }

        public Criteria andVZyidNotBetween(String value1, String value2) {
            addCriterion("v_zyid not between", value1, value2, "vZyid");
            return (Criteria) this;
        }

        public Criteria andDFhrqIsNull() {
            addCriterion("d_fhrq is null");
            return (Criteria) this;
        }

        public Criteria andDFhrqIsNotNull() {
            addCriterion("d_fhrq is not null");
            return (Criteria) this;
        }

        public Criteria andDFhrqEqualTo(Date value) {
            addCriterion("d_fhrq =", value, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqNotEqualTo(Date value) {
            addCriterion("d_fhrq <>", value, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqGreaterThan(Date value) {
            addCriterion("d_fhrq >", value, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqGreaterThanOrEqualTo(Date value) {
            addCriterion("d_fhrq >=", value, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqLessThan(Date value) {
            addCriterion("d_fhrq <", value, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqLessThanOrEqualTo(Date value) {
            addCriterion("d_fhrq <=", value, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqIn(List<Date> values) {
            addCriterion("d_fhrq in", values, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqNotIn(List<Date> values) {
            addCriterion("d_fhrq not in", values, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqBetween(Date value1, Date value2) {
            addCriterion("d_fhrq between", value1, value2, "dFhrq");
            return (Criteria) this;
        }

        public Criteria andDFhrqNotBetween(Date value1, Date value2) {
            addCriterion("d_fhrq not between", value1, value2, "dFhrq");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * zy_zybhzb 
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