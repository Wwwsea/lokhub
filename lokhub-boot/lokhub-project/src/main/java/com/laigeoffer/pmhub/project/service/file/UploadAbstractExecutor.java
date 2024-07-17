package com.laigeoffer.lokhub.project.service.file;

import com.laigeoffer.lokhub.common.core.domain.model.LoginUser;
import com.laigeoffer.lokhub.project.domain.vo.project.file.FileVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fish
 * @date 2023-01-03 17:22
 */
public abstract class UploadAbstractExecutor {
    public abstract FileVO upload(LoginUser user, MultipartFile file, String id) throws Exception;
}
