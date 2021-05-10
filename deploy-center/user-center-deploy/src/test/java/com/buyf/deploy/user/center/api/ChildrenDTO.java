package com.buyf.deploy.user.center.api;

import java.util.List;

public class ChildrenDTO {
    @ParamPropertyList(
            paramProperty = {
                    @ParamProperty(paramsName = "产品编码", dataType = "varchar"),
                    @ParamProperty(paramsName = "险种编码", dataType = "varchar"),
                    @ParamProperty(paramsName = "计划编码", dataType = "varchar"),
            })
    private String code;

    @ParamPropertyList(
            paramProperty = {
                    @ParamProperty(paramsName = "产品名称", dataType = "varchar"),
                    @ParamProperty(paramsName = "险种名称", dataType = "varchar"),
                    @ParamProperty(paramsName = "计划名称", dataType = "varchar"),
            })
    private String name;
    @ParamProperty(dataType = "object", paramsName = "fieldsDto")
    private FieldsDTO fieldsDto;
    @ParamProperty(dataType = "object", paramsName = "childrenDTO")
    private List<ChildrenDTO> childrenDTO;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldsDTO getFieldsDto() {
        return fieldsDto;
    }

    public void setFieldsDto(FieldsDTO fieldsDto) {
        this.fieldsDto = fieldsDto;
    }

    public List<ChildrenDTO> getChildrenDTO() {
        return childrenDTO;
    }

    public void setChildrenDTO(List<ChildrenDTO> childrenDTO) {
        this.childrenDTO = childrenDTO;
    }

}


