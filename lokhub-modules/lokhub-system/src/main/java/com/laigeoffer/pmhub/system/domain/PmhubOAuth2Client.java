package com.laigeoffer.lokhub.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * OAuth2 client
 * @author fish
 * @date 2024/01/08
 */
@Data
@TableName("lokhub_oauth2_client")
public class lokhubOAuth2Client {

    String id;

    /**
     * 客户端名称
     */
    String clientName;

    /**
     * 客户端id
     */
    String clientId;

    /**
     * 客户端授权Secret
     */
    String clientSecret;

    /**
     * 客户端图标
     */
    String img;

}
