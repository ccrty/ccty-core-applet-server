package com.distance.src.aop.aspect.exception;

/**
 * @author 缄默
 * @date 2019/5/23
 */
public class NoahException extends RuntimeException {

    private static final long serialVersionUID = -3414443277824683844L;
    private String code;

    public NoahException(String code) {
        this.code = code;
    }

    public NoahException(String code, Object message) {
        super(message.toString());
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
