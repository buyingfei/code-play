package com.buyf.deploy.user.center.api;

public enum YesOrNoEnum {

    YES(1,"YES"),
        NO(2,"NO");
     YesOrNoEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    Integer code;
    String desc;

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
