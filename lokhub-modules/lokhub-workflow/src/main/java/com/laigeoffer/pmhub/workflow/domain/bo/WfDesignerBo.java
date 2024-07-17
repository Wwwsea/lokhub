package com.laigeoffer.lokhub.workflow.domain.bo;

import com.laigeoffer.lokhub.base.core.core.validate.AddGroup;
import com.laigeoffer.lokhub.base.core.core.validate.EditGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 流程设计业务对象
 *
 * @author fish
 * @createTime 2022/3/10 00:12
 */
@Data
public class WfDesignerBo {

    /**
     * 流程名称
     */
    @NotNull(message = "流程名称", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 流程分类
     */
    @NotBlank(message = "流程分类", groups = { AddGroup.class, EditGroup.class })
    private String category;

    /**
     * XML字符串
     */
    @NotBlank(message = "XML字符串", groups = { AddGroup.class, EditGroup.class })
    private String xml;
}
