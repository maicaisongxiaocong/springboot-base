package com.hebut.base.common.exception;

/**
 * @description: 服务接口类
 */
public interface BaseErrorInfoInterface {

    /**
     *  错误码
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     * @return
     */
    String getResultMsg();
}
