package com.laigeoffer.lokhub.system.domain;

import lombok.Data;

/**
 * OAuth2 用于客户端请求接口的token
 * @author fish
 * @date 2024/01/10
 */
@Data
public class lokhubOAuth2Token {

    public lokhubOAuth2Token(){
        this.token_type = "bearer";
        this.scope = "profile";
    }

    /**
     * token
     */
    String access_token;

    /**
     * token 类型
     */
    String token_type;

    /**
     * token 可用的范围
     */
    String scope;


}
