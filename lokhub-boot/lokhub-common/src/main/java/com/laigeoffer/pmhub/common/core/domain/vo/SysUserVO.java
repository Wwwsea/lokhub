package com.laigeoffer.lokhub.common.core.domain.vo;

import com.laigeoffer.lokhub.common.annotation.Excel;
import com.laigeoffer.lokhub.common.core.domain.entity.SysUser;

/**
 * 用户对象 sys_user
 *
 * @author fish
 */
public class SysUserVO extends SysUser {

    /**
     * 是否绑定企微
     */
    @Excel(name = "企微状态")
    private String userWxNameState;

    public String getUserWxNameState() {
        return userWxNameState;
    }

    public void setUserWxNameState(String userWxNameState) {
        this.userWxNameState = userWxNameState;
    }
}
