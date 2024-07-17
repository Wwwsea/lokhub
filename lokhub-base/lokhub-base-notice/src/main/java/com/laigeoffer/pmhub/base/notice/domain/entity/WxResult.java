package com.laigeoffer.lokhub.base.notice.domain.entity;

import lombok.Data;

/**
 * 企微返回消息
 * @author fish
 */
@Data
public class WxResult {

    private String errcode;

    private String errmsg;

    private String msgid;

    private String response_code;

}
