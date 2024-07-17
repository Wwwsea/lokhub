package com.laigeoffer.lokhub.oa.enums.wx;

/**
 * 按钮状态
 * @author fish
 */
public enum ButtonStateEnum {

    /**
     * 按钮交互型
     * */
    FINISH("已处理"),

    /**
     * 文本通知型
     * */
    OVERTIME("已失效");


    private String desc;

    ButtonStateEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString(){
        return desc;
    }
}
