package com.buyf.deploy.user.center;

public enum  ParamPropertyTypeEnum {
    RECURSION(1,"递归")
    ;
    private Integer code;
    private String desc;

    ParamPropertyTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
