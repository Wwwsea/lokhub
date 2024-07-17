package com.laigeoffer.lokhub.workflow.service;

import com.laigeoffer.lokhub.common.core.domain.PageQuery;
import com.laigeoffer.lokhub.common.core.page.Table2DataInfo;
import com.laigeoffer.lokhub.workflow.core.domain.ProcessQuery;
import com.laigeoffer.lokhub.workflow.domain.dto.ApprovalSetDTO;
import com.laigeoffer.lokhub.workflow.domain.dto.MaterialsApprovalSetDTO;
import com.laigeoffer.lokhub.workflow.domain.vo.MaterialsApprovalSetVO;
import com.laigeoffer.lokhub.workflow.domain.vo.WfDeployVo;
import com.laigeoffer.lokhub.workflow.domain.WfMaterialsScrappedProcess;
import com.laigeoffer.lokhub.workflow.domain.WfTaskProcess;

import java.util.List;

/**
 * @author fish
 * @createTime 2022/6/30 9:03
 */
public interface IWfDeployService {

    Table2DataInfo<WfDeployVo> queryPageList(ProcessQuery processQuery, PageQuery pageQuery);

    Table2DataInfo<WfDeployVo> queryPublishList(String processKey, PageQuery pageQuery);

    void updateState(String definitionId, String stateCode);

    String queryBpmnXmlById(String definitionId);

    void deleteByIds(List<String> deployIds);

    void approvalSet(MaterialsApprovalSetDTO approvalSetDTO, String type);
    MaterialsApprovalSetVO queryApprovalSet(String type, String taskId);
    void updateApprovalSet(ApprovalSetDTO approvalSetDTO, String type);
    void updateApprovalSet2(ApprovalSetDTO approvalSetDTO, String type);
    void insertApprovalSet();
    WfTaskProcess insertWfTaskProcess(String extraId, String type, String approved, String definitionId, String deploymentId);
    void insertOrUpdateApprovalSet(String extraId, String type, String approved, String definitionId, String deploymentId);
    List<WfMaterialsScrappedProcess> insertScrappedProcess(List<String> ids, MaterialsApprovalSetVO materialsApprovalSetVO);
    List<WfTaskProcess> selectList(List<String> taskId);
    List<WfTaskProcess> selectWfTaskProcessList(List<String> extraId, String type);
    void updateProviderApproval(String providerId);
    List<WfMaterialsScrappedProcess> selectScrappedList(List<String> ids);
}
