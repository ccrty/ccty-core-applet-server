package com.ccty.noah.domain.constance;

/**
 * @author 缄默
 * @date   2020/12/22
 */
public interface RunnerConst {

    /**
     * 跑腿订单状态
     */
    static enum OrderStatus{
        //
        PUBLISHED(0,"已发布"),
        DELIVERING(1,"派送中"),
        FINISHED(2,"订单结束"),
        CANCEL(3,"订单取消"),
        EXCEPTION(4,"订单异常");
        private Integer code;
        private String name;

        OrderStatus(Integer code, String name) {
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
