package com.yidiantong.service;

import com.yidiantong.dto.ResultData;
import org.springframework.stereotype.Service;

/**
 * 赠品接口
 * Created by wujw on 17/4/24.
 */
@Service
public interface GiftService {
    /**
     * 获取赠品列表
     * @return
     */
    public ResultData getGiftList() throws Exception;
}
