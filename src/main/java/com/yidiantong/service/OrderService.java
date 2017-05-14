package com.yidiantong.service;

import com.yidiantong.dto.ResultData;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 订单接口
 * Created by wujw on 17/4/24.
 */
@Service
public interface OrderService {
    /**
     * 查询订单
     * @return
     */
    public ResultData getOrderList(String userid) throws Exception;

    /**
     * 提交订单
     * @param map
     * @return
     * @throws Exception
     */
    public ResultData addOrderList(Map map) throws Exception;
}
