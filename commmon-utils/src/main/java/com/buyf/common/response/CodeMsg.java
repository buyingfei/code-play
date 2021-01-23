package com.buyf.common.response;

/**
 * @author buyf
 * @date 2021/1/23 10:10
 * @desc
 */
public enum CodeMsg {
    // 按照模块定义CodeMsg
    SUCCESS(0,"success"),
    SERVER_EXCEPTION(500100,"服务端异常"),
    PARAMETER_ISNULL(500101,"输入参数为空"),

    // 业务异常
    USER_NOT_EXSIST(500102,"USER_NOT_EXSIST");

    private int retCode;
    private String message;

    private CodeMsg(int retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }
    public int getRetCode() {
        return retCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
