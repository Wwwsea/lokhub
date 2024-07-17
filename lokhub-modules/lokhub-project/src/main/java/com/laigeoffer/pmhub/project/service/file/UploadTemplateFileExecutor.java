package com.laigeoffer.lokhub.project.service.file;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.laigeoffer.lokhub.base.core.config.lokhubConfig;
import com.laigeoffer.lokhub.base.core.core.domain.model.LoginUser;
import com.laigeoffer.lokhub.base.core.enums.ProjectStatusEnum;
import com.laigeoffer.lokhub.base.core.exception.ServiceException;
import com.laigeoffer.lokhub.base.core.utils.file.FileUploadUtils;
import com.laigeoffer.lokhub.base.core.utils.file.FileUtils;
import com.laigeoffer.lokhub.base.core.utils.file.MimeTypeUtils;
import com.laigeoffer.lokhub.project.domain.ProjectFile;
import com.laigeoffer.lokhub.project.domain.vo.project.file.FileVO;
import com.laigeoffer.lokhub.project.mapper.ProjectFileMapper;
import com.laigeoffer.lokhub.project.mapper.ProjectTaskMapper;
import com.laigeoffer.lokhub.project.utils.ProjectFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fish
 * @date 2023-01-09 09:37
 */
@Service("uploadTemplateFileExecutor")
@Slf4j
public class UploadTemplateFileExecutor extends UploadAbstractExecutor {
    @Autowired
    private ProjectTaskMapper projectTaskMapper;
    @Autowired
    private ProjectFileMapper projectFileMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileVO upload(LoginUser user, MultipartFile file, String id) throws Exception {
        log.info("模板上传的的任务id:{}", id);
        String templatePath = ProjectFileUtil.uploadTaskFile(lokhubConfig.getTemplatePath(), file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        if (StringUtils.isBlank(templatePath)) {
            throw new ServiceException("上传文件异常，请联系管理员");
        }
        // 删除原来的模板
        LambdaQueryWrapper<ProjectFile> lw = new LambdaQueryWrapper<>();
        lw.eq(ProjectFile::getPtId, id).eq(ProjectFile::getType, ProjectStatusEnum.TEMPLATE.getStatusName());
        List<ProjectFile> projectFiles = projectFileMapper.selectList(lw);
        List<String> ids = projectFiles.stream().map(ProjectFile::getId).collect(Collectors.toList());
        List<String> fileUrls = projectFiles.stream().map(ProjectFile::getPathName).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(ids)) {
            projectFileMapper.deleteBatchIds(ids);
        }
        fileUrls.forEach(FileUtils::deleteFile);

        String pn = ProjectFileUtil.getPathName(lokhubConfig.getTemplatePath(), file);
        ProjectFile projectFile = new ProjectFile();
        projectFile.setFileSize(new BigDecimal(String.valueOf(file.getSize())).divide(new BigDecimal("1024"), 2, RoundingMode.HALF_UP));
        projectFile.setFileName(file.getOriginalFilename());
        projectFile.setFileUrl(templatePath);
        projectFile.setUserId(user.getUserId());
        projectFile.setCreatedBy(user.getUsername());
        projectFile.setCreatedTime(new Date());
        projectFile.setUpdatedBy(user.getUsername());
        projectFile.setUpdatedTime(new Date());
        projectFile.setType(ProjectStatusEnum.TEMPLATE.getStatusName());
        projectFile.setPtId(id);
        projectFile.setExtension(FileUploadUtils.getExtension(file));
        projectFile.setProjectId(projectTaskMapper.selectById(id).getProjectId());
        projectFile.setPathName(pn);
        projectFileMapper.insert(projectFile);

        FileVO fileVO = new FileVO();
        fileVO.setProjectFileId(projectFile.getId());
        fileVO.setFileName(file.getOriginalFilename());
        fileVO.setFileUrl(templatePath);
        return fileVO;
    }
}
