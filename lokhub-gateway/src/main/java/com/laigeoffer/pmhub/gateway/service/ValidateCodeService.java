package com.laigeoffer.lokhub.gateway.service;


import com.laigeoffer.lokhub.base.core.core.domain.AjaxResult;
import com.laigeoffer.lokhub.base.core.exception.user.CaptchaException;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author fish
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
