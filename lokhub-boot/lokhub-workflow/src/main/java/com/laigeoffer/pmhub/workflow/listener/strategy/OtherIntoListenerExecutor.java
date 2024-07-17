package com.laigeoffer.lokhub.workflow.listener.strategy;

import com.alibaba.fastjson2.JSON;
import com.laigeoffer.lokhub.oa.domain.workWx.dto.body.action.OtherIntoRemindDTO;
import com.laigeoffer.lokhub.oa.utils.RocketMqUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 其他入库监听
 * @author fish
 * @date 2023-07-11 09:37
 */
@Slf4j
@Service("otherIntoListenerExecutor")
public class OtherIntoListenerExecutor extends ListenerAbstractExecutor {
    @Override
    public void push2Wx(ListenerDTO listenerDTO) {
        log.info("其他入库审批发送消息:{}", JSON.toJSONString(listenerDTO));
        OtherIntoRemindDTO otherIntoRemindDTO = new OtherIntoRemindDTO();
        BeanUtils.copyProperties(listenerDTO, otherIntoRemindDTO);
        RocketMqUtils.push2Wx(otherIntoRemindDTO);
    }
}
