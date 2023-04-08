package com.hebut.base.common;

/**
 * @program: base
 * @description: 统一返回结果封装
 * @author: cxc
 * @create: 2023-04-08 10:09
 **/

import com.alibaba.fastjson.JSONObject;
import com.hebut.base.common.exception.BaseErrorInfoInterface;
import com.hebut.base.common.exception.ExceptionEnum;

/**
 * @description: 自定义数据传输
 * @author: DT
 * @date: 2021/4/19 21:47
 * @version: v1.0
 */
public class ResultResponse {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultResponse() {
    }

    public ResultResponse(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultResponse success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultResponse success(Object data) {
        ResultResponse rb = new ResultResponse();
        rb.setCode(ExceptionEnum.SUCCESS.getResultCode());
        rb.setMessage(ExceptionEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultResponse error(BaseErrorInfoInterface errorInfo) {
        ResultResponse rb = new ResultResponse();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultResponse error(String code, String message) {
        ResultResponse rb = new ResultResponse();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultResponse error( String message) {
        ResultResponse rb = new ResultResponse();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
