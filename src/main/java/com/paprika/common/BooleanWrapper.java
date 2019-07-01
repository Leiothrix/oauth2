package com.paprika.common;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author adam
 * @date 2019/7/1
 */
@ApiModel("响应内容")
@Getter
@Setter
public class BooleanWrapper<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    public static final int FAIL_CODE = 201;

    public static final int SUCCESS_CODE = 200;

    public static final int BUSINESS_ERROR_CODE = 202;

    /**
     * 响应代码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public BooleanWrapper() {
        this(SUCCESS_CODE, null);
    }

    public BooleanWrapper(int code) {
        this(code, null);
    }

    public BooleanWrapper(T data) {
        this(SUCCESS_CODE, null , data);
    }

    public BooleanWrapper(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BooleanWrapper(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
