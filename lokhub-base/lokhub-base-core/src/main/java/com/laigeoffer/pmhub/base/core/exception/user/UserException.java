package com.laigeoffer.lokhub.base.core.exception.user;


import com.laigeoffer.lokhub.base.core.exception.base.BaseException;

/**
 * 用户信息异常类
 *
 * @author fish
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
