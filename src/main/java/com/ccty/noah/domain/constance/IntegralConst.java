package com.ccty.noah.domain.constance;

/**
 * @author 缄默
 * @date   2020/12/22
 */
public interface IntegralConst {

    //操作类型-扣除
    Integer OPERATE_SUBTRACT = 2;

    //操作类型-增加
    Integer OPERATE_ADD = 1;

    /**
     * 积分类型
     */
    static enum IntegralType{
        //
        RUNNER(1,"跑腿"),
        INVITATION(2,"论坛");

        private Integer code;
        private String name;

        IntegralType(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 积分状态
     */
    static enum IntegralStatus{
        //
        EFFECTIVE(1,"有效"),
        DEDUCTION(2,"已扣除"),
        EXPIRED(3,"已过期"),
        FREEZING(4,"冻结中"),
        FREEZE_RETURN(5,"冻结返还"),
        FREEZE_DEDUCTION(6,"冻结扣减");
        private Integer code;
        private String name;

        IntegralStatus(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 积分来源
     */
    static enum IntegralSources{
        //
        RECHARGE(1,"充值"),
        GIFT(2,"赠送"),
        INVITATION(3,"论坛");

        private Integer code;
        private String name;

        IntegralSources(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
