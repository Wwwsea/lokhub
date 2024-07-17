package com.laigeoffer.lokhub.project.service.file;

/**
 * @author fish
 * @date 2023-01-03 17:24
 */

public enum UploadTypeEnum {

    PROJECT("project", "uploadProjectFileExecutor"),
    TASK("task", "uploadTaskFileExecutor"),
    COVER("cover", "uploadCoverFileExecutor"),
    TEMPLATE("template", "uploadTemplateFileExecutor");
    private final String type;
    private final String beanName;
    UploadTypeEnum(String type, String beanName) {
        this.type = type;
        this.beanName = beanName;
    }

    public String getType() {
        return type;
    }

    public String getBeanName() {
        return beanName;
    }
}
