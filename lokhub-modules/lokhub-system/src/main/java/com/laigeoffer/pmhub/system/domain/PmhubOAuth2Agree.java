package com.laigeoffer.lokhub.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * OAuth2 用户已统一登陆客户端
 * @author fish
 * @date 2024/01/08
 */
@Data
@TableName("lokhub_oauth2_agree")
public class lokhubOAuth2Agree {

    String id;

    /**
     * 客户端名称
     */
    Long userId;

    /**
     * 客户端id
     */
    String clientId;

}
