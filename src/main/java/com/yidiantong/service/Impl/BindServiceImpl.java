package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.BindService;
import com.yidiantong.service.GiftService;
import com.yidiantong.utils.HttpUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 绑定
 * Created by wujw on 17/4/24.
 */
@Service
public class BindServiceImpl extends BaseService implements BindService {
    private Map map;

    @Override
    public ResultData addBind(Map map) throws Exception {
        JSONObject json=new JSONObject();
        json.put("userid",map.get("userid").toString());
        json.put("openid",map.get("openid").toString());
        String data=HttpUtils.sendJsonPost(BaseUrls.URL_BDXXB0_ADD,json);
        return dto._data(getStatus(data),data);
    }

    @Override
    public ResultData getBindInfo(String openid) throws Exception {
        map=new HashMap<>();
        map.put("wechatId",openid);

        String data=HttpUtils.sendGet(BaseUrls.URL_BDXXB0_QUERY,map,false);
        return dto._data(getStatus(data),data);
    }
}
