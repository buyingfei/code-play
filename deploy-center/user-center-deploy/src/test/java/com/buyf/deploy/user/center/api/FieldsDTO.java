package com.buyf.deploy.user.center.api;

public class FieldsDTO {
    @ParamProperty(paramsName ="是否是基础产品",dataType="varchar",allowableEnum = YesOrNoEnum.class)
    private String baseProductCheck; // 是否是基础产品：Y-是，N-否
    @ParamProperty(paramsName ="是否绑定至基础产品",dataType="varchar",allowableEnum = YesOrNoEnum.class)
    private String bindBaseCheck;// 是否绑定至基础产品：Y-是，N-否

    public String getBaseProductCheck() {
        return baseProductCheck;
    }

    public void setBaseProductCheck(String baseProductCheck) {
        this.baseProductCheck = baseProductCheck;
    }

    public String getBindBaseCheck() {
        return bindBaseCheck;
    }

    public void setBindBaseCheck(String bindBaseCheck) {
        this.bindBaseCheck = bindBaseCheck;
    }

    @Override
    public String toString() {
        return "FieldsDTO{" +
                "baseProductCheck='" + baseProductCheck + '\'' +
                ", bindBaseCheck='" + bindBaseCheck + '\'' +
                '}';
    }
}
