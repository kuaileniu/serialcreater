package cn.zhsit.models.po;

import java.util.ArrayList;
import java.util.List;

public class ZyZytybhbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZyZytybhbExample() {
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
     * zy_zytybhb 
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

        public Criteria andVCpflqhIsNull() {
            addCriterion("v_cpflqh is null");
            return (Criteria) this;
        }

        public Criteria andVCpflqhIsNotNull() {
            addCriterion("v_cpflqh is not null");
            return (Criteria) this;
        }

        public Criteria andVCpflqhEqualTo(String value) {
            addCriterion("v_cpflqh =", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhNotEqualTo(String value) {
            addCriterion("v_cpflqh <>", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhGreaterThan(String value) {
            addCriterion("v_cpflqh >", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhGreaterThanOrEqualTo(String value) {
            addCriterion("v_cpflqh >=", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhLessThan(String value) {
            addCriterion("v_cpflqh <", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhLessThanOrEqualTo(String value) {
            addCriterion("v_cpflqh <=", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhLike(String value) {
            addCriterion("v_cpflqh like", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhNotLike(String value) {
            addCriterion("v_cpflqh not like", value, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhIn(List<String> values) {
            addCriterion("v_cpflqh in", values, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhNotIn(List<String> values) {
            addCriterion("v_cpflqh not in", values, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhBetween(String value1, String value2) {
            addCriterion("v_cpflqh between", value1, value2, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpflqhNotBetween(String value1, String value2) {
            addCriterion("v_cpflqh not between", value1, value2, "vCpflqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhIsNull() {
            addCriterion("v_cpfldqh is null");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhIsNotNull() {
            addCriterion("v_cpfldqh is not null");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhEqualTo(String value) {
            addCriterion("v_cpfldqh =", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhNotEqualTo(String value) {
            addCriterion("v_cpfldqh <>", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhGreaterThan(String value) {
            addCriterion("v_cpfldqh >", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhGreaterThanOrEqualTo(String value) {
            addCriterion("v_cpfldqh >=", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhLessThan(String value) {
            addCriterion("v_cpfldqh <", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhLessThanOrEqualTo(String value) {
            addCriterion("v_cpfldqh <=", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhLike(String value) {
            addCriterion("v_cpfldqh like", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhNotLike(String value) {
            addCriterion("v_cpfldqh not like", value, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhIn(List<String> values) {
            addCriterion("v_cpfldqh in", values, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhNotIn(List<String> values) {
            addCriterion("v_cpfldqh not in", values, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhBetween(String value1, String value2) {
            addCriterion("v_cpfldqh between", value1, value2, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpfldqhNotBetween(String value1, String value2) {
            addCriterion("v_cpfldqh not between", value1, value2, "vCpfldqh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhIsNull() {
            addCriterion("v_cpflzh is null");
            return (Criteria) this;
        }

        public Criteria andVCpflzhIsNotNull() {
            addCriterion("v_cpflzh is not null");
            return (Criteria) this;
        }

        public Criteria andVCpflzhEqualTo(String value) {
            addCriterion("v_cpflzh =", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhNotEqualTo(String value) {
            addCriterion("v_cpflzh <>", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhGreaterThan(String value) {
            addCriterion("v_cpflzh >", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhGreaterThanOrEqualTo(String value) {
            addCriterion("v_cpflzh >=", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhLessThan(String value) {
            addCriterion("v_cpflzh <", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhLessThanOrEqualTo(String value) {
            addCriterion("v_cpflzh <=", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhLike(String value) {
            addCriterion("v_cpflzh like", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhNotLike(String value) {
            addCriterion("v_cpflzh not like", value, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhIn(List<String> values) {
            addCriterion("v_cpflzh in", values, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhNotIn(List<String> values) {
            addCriterion("v_cpflzh not in", values, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhBetween(String value1, String value2) {
            addCriterion("v_cpflzh between", value1, value2, "vCpflzh");
            return (Criteria) this;
        }

        public Criteria andVCpflzhNotBetween(String value1, String value2) {
            addCriterion("v_cpflzh not between", value1, value2, "vCpflzh");
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
     * zy_zytybhb 
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