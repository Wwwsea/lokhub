package com.laigeoffer.lokhub.oa.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fish
 * @date 2023-04-10 10:59
 */
@Data
public class MessageDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msgCode;
    private Long msgTime;
    private String wxUserName;
}
