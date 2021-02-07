package com.buyf.domain.user.dto;

import com.buyf.common.dto.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * @author buyf
 * @date 2021/2/3 15:40
 * @desc
 */
@Getter
@Setter
public class UserDTO extends PageQuery {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 微信openid
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String salt;

    /**
     * 用户签名
     */
    private String token;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    private Boolean isDeleted;

}
