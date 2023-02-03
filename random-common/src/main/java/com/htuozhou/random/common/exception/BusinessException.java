package com.htuozhou.random.common.exception;

import com.htuozhou.random.common.result.ResultCodeEnum;

/**
 * @author hanzai
 * @date 2023/2/2
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    private String msg;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BusinessException() {
        this.code = ResultCodeEnum.FAIL.getCode();
        this.msg = ResultCodeEnum.FAIL.getMsg();
    }

    public BusinessException(Object data) {
        this.code = ResultCodeEnum.FAIL.getCode();
        this.msg = ResultCodeEnum.FAIL.getMsg();
        this.data = data;
    }

    public BusinessException(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }
}
