package com.distance.src.aop.aspect;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 缄默
 * @date 2019/5/23
 */
@Data
public class NoahResult<T> implements Serializable {
    private static final long serialVersionUID = -2374692223790170928L;

    private T data;

    private String code;

    private Object msg;

    private NoahResult() {
        this.code = "200";
        this.msg = "success";
    }

    private NoahResult success(T data) {
        this.data = data;
        return this;
    }

    private NoahResult fail(String code, Object msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public static NoahResult builderSuccess(Object o) {
        return new NoahResult().success(o);
    }

    public static NoahResult builderFail(String code, Object msg) {
        return new NoahResult().fail(code, msg);
    }

    public T getData() {
        return this.data;
    }

    public String getCode() {
        return this.code;
    }

    public Object getMsg() {
        return this.msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        NoahResult<?> that = (NoahResult<?>) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(code, that.code) &&
                Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, code, msg);
    }

    protected boolean canEqual(Object other) {
        return other instanceof NoahResult;
    }

    @Override
    public String toString() {
        return "NoahResult{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", msg=" + msg +
                '}';
    }
}
