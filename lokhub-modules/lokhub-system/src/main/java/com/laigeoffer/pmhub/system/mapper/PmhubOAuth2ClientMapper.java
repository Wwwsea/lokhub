package com.laigeoffer.lokhub.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laigeoffer.lokhub.system.domain.lokhubOAuth2Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * OAuth2客户端 数据层
 *
 * @author fish
 */
@Mapper
public interface lokhubOAuth2ClientMapper extends BaseMapper<lokhubOAuth2Client> {

}
