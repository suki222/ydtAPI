package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.GiftService;
import com.yidiantong.service.OrderService;
import com.yidiantong.utils.HttpUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单逻辑类
 * Created by wujw on 17/4/24.
 */
@Service
public class OrderServiceImpl extends BaseService implements OrderService {
    private Map map;

    @Override
    public ResultData getOrderList(String userid) throws Exception {
        map=new HashMap<>();
        map.put("userid",userid);
        String data=HttpUtils.sendGet(BaseUrls.URL_DDB000_LIST,map,false);
        return dto._data(getStatus(data),data);
    }

    @Override
    public ResultData addOrderList(Map map) throws Exception {
        JSONObject json=new JSONObject();
        json.put("userid",map.get("userid").toString());
        json.put("dwmc00",map.get("dwmc00").toString());
        json.put("ddje00",map.get("ddje00").toString());
        json.put("httzdz",map.get("httzdz").toString());
        json.put("zp0000",map.get("zp0000").toString());
        json.put("spmc00",map.get("spmc00").toString());
        json.put("fpmc00",map.get("fpmc00").toString());
        json.put("sjrdz0",map.get("sjrdz0").toString());
        json.put("sjrxm0",map.get("sjrxm0").toString());
        json.put("sjrdh0",map.get("sjrdh0").toString());
        json.put("zpdz00",map.get("zpdz00").toString());
        json.put("zplxr0",map.get("zplxr0").toString());
        json.put("zplxrdh",map.get("zplxrdh").toString());
        json.put("fplx00",map.get("fplx00").toString());
        String data=HttpUtils.sendJsonPost(BaseUrls.URL_DDB000_LIST,json);
        String payData="";
        if(!data.isEmpty()){
            JSONObject newJson=new JSONObject(data);
            Map payMap=new HashMap<>();
            payMap.put("outChargeNo",newJson.optString("ddh000"));//商户订单号
            System.out.println("=======支付-payJson======="+payMap.toString());
            payData=HttpUtils.sendPost(BaseUrls.URL_PAYAPI_PAY,payMap);
            System.out.println("=======支付-payData======="+payData);
        }
        return dto._data(getStatus(payData),payData);
    }
}
