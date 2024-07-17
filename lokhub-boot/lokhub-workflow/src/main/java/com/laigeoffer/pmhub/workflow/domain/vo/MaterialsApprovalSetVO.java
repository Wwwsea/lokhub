package com.laigeoffer.lokhub.workflow.domain.vo;

import lombok.Data;

/**
 * @author fish
 * @date 2023-04-23 13:55
 */
@Data
public class MaterialsApprovalSetVO {

    private String type;
    private String approved;
    private String definitionId;
    private String deploymentId;
}
