package com.laigeoffer.lokhub.base.core.exception.user;

/**
 * 验证码错误异常类
 *
 * @author fish
 */
public class CaptchaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg)
    {
        super(msg);
    }
}
