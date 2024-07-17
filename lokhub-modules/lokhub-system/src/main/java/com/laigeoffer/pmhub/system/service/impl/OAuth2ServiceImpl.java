package com.laigeoffer.lokhub.system.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laigeoffer.lokhub.base.core.config.redis.RedisService;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysUser;
import com.laigeoffer.lokhub.system.domain.lokhubOAuth2Agree;
import com.laigeoffer.lokhub.system.domain.lokhubOAuth2Client;
import com.laigeoffer.lokhub.system.domain.lokhubOAuth2User;
import com.laigeoffer.lokhub.system.mapper.lokhubOAuth2AgreeMapper;
import com.laigeoffer.lokhub.system.mapper.lokhubOAuth2ClientMapper;
import com.laigeoffer.lokhub.system.service.IOAuth2Service;
import com.laigeoffer.lokhub.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OAuth2ServiceImpl implements IOAuth2Service {

    @Autowired
    private lokhubOAuth2AgreeMapper lokhubOAuth2AgreeMapper;

    @Autowired
    private lokhubOAuth2ClientMapper lokhubOAuth2ClientMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ISysUserService iSysUserService;

    /**
     * redis中code作为key的前缀
     */
    private static final String CODE_TITLE = "auth2_code:";

    /**
     * redis中token作为key的前缀
     */
    private static final String TOKEN_TITLE = "auth2_token:";


    /**
     * 是否已被用户授权登录
     *
     * @param userId   用户id
     * @param clientId 客户端id
     * @return {@link Boolean}
     */
    @Override
    public Boolean isAgree(Long userId, String clientId) {

        QueryWrapper<lokhubOAuth2Agree> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("client_id", clientId);

        // 数据库中如果有这个授权就返回true
        long count = lokhubOAuth2AgreeMapper.selectCount(queryWrapper);
        return count > 0;
    }

    /**
     * 允许授权登录
     *
     * @param userId   用户id
     * @param clientId 客户端id
     */
    @Override
    public void agree(Long userId, String clientId) {
        if (ObjectUtil.isNotEmpty(clientId)){
            lokhubOAuth2Agree lokhubOAuth2Agree = new lokhubOAuth2Agree();
            lokhubOAuth2Agree.setId(IdUtil.fastUUID());

            lokhubOAuth2Agree.setClientId(clientId);
            lokhubOAuth2Agree.setUserId(userId);

            lokhubOAuth2AgreeMapper.insert(lokhubOAuth2Agree);
        }else {
            throw new RuntimeException("ClientID can not null!");
        }
    }

    /**
     * 创建用于授权的用户code
     *
     * @param userId 用户id
     * @return {@link String}
     */
    @Override
    public String createCode(Long userId) {
        String code = IdUtil.simpleUUID();
        // 授权码1分钟过期
        redisService.setCacheObject(CODE_TITLE+code,userId,1, TimeUnit.MINUTES);
        return code;
    }

    /**
     * 创建用于授权的用户token
     *
     * @param code 用户code
     * @return {@link String}
     */
    @Override
    public String createToken(String code) {
        Long userId = redisService.getCacheObject(CODE_TITLE+code);
        // 清除code
        redisService.deleteObject(CODE_TITLE+code);
        if (ObjectUtil.isNotEmpty(userId)){
            String token = IdUtil.randomUUID();
            // token 15分钟过期
            redisService.setCacheObject(TOKEN_TITLE+token,userId,15, TimeUnit.MINUTES);
            return token;
        }else {
            return null;
        }
    }

    /**
     * 更加token获取用户信息
     * @param token token
     * @return {@link lokhubOAuth2User}
     */
    @Override
    public lokhubOAuth2User getUser(String token){
        Long userId = redisService.getCacheObject(TOKEN_TITLE+token);
        if (ObjectUtil.isNotEmpty(userId)){
            SysUser sysUser = iSysUserService.selectUserById(userId);
            lokhubOAuth2User lokhubOAuth2User = new lokhubOAuth2User();
            lokhubOAuth2User.setSub(sysUser.getUserName());
            lokhubOAuth2User.setName(sysUser.getNickName());
            lokhubOAuth2User.setPreferred_username(sysUser.getUserName());
            lokhubOAuth2User.setEmail(sysUser.getEmail());
            lokhubOAuth2User.setUpdated_at(sysUser.getCreateTime().toString());
            return lokhubOAuth2User;
        }else {
            return null;
        }
    }

    /**
     * 获取客户端logo
     *
     * @param clientId clientId
     * @return {@link lokhubOAuth2User}
     */
    @Override
    public lokhubOAuth2Client getClientInfo(String clientId) {

        QueryWrapper<lokhubOAuth2Client> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", clientId);
        lokhubOAuth2Client lokhubOAuth2Client =  lokhubOAuth2ClientMapper.selectOne(queryWrapper);
        if (ObjectUtil.isNotEmpty(lokhubOAuth2Client)){
            lokhubOAuth2Client.setClientSecret(null);
        }
        return lokhubOAuth2Client;
    }

    /**
     * 验证客户端的Secret
     *
     * @param clientId
     * @param clientSecret
     * @return {@link Boolean}
     */
    @Override
    public Boolean checkClientSecret(String clientId, String clientSecret) {

        QueryWrapper<lokhubOAuth2Client> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", clientId);
        return lokhubOAuth2ClientMapper.selectOne(queryWrapper).getClientSecret().equals(clientSecret);

    }
}
