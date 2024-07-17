package com.laigeoffer.lokhub.base.notice.domain.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

/**
 * 微信消息和taskid对应表
 * @author fish
 */
@Data
public class MessageCode {

    String id;

    String taskId;

    String messageCode;

    /**
     * 消息时间
     * */
    DateTime createTime;
}
