package com.yidiantong.service;

import com.yidiantong.dto.ResultData;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 绑定接口
 * Created by wujw on 17/4/24.
 */
@Service
public interface BindService {
    /**
     * 新增绑定信息
     * @return
     */
    public ResultData addBind(Map map) throws Exception;

    /**
     * 获取绑定信息
     * @return
     * @throws Exception
     */
    public ResultData getBindInfo(String openid) throws Exception;
}
