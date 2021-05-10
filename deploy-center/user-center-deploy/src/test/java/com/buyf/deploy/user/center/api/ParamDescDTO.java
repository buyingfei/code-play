package com.buyf.deploy.user.center.api;

public class ParamDescDTO {
    private Integer intefacePkId;
    private String id;
    private String pid;
    private String paramName;
    private String paramDesc;
    private String paramType;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Integer getIntefacePkId() {
        return intefacePkId;
    }

    public void setIntefacePkId(Integer intefacePkId) {
        this.intefacePkId = intefacePkId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ParamDescDTO{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", paramName='" + paramName + '\'' +
                ", paramDesc='" + paramDesc + '\'' +
                ", paramType='" + paramType + '\'' +
                '}';
    }
}
