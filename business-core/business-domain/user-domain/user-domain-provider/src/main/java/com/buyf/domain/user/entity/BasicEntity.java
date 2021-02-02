package com.buyf.domain.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class BasicEntity {
    @TableId
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
