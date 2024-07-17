package com.laigeoffer.lokhub.workflow.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fish
 * @date 2023-04-04 09:11
 */
@Data
@TableName("lokhub_task_message_deal")
public class WfTaskMessageDeal {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String taskId;
    private String instanceId;
    private String assignee;
}
