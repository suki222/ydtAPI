package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import com.yidiantong.dao.TestDao;
import com.yidiantong.dto.ResultData;
import com.yidiantong.enums.BaseCode;
import com.yidiantong.service.GiftService;
import com.yidiantong.service.TestService;
import com.yidiantong.utils.HttpUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 赠品实现类
 * Created by wujw on 17/4/24.
 */
@Service
public class GiftServiceImpl extends BaseService implements GiftService{
    private Map map;

    @Override
    public ResultData getGiftList() throws Exception {
        map=new HashMap<>();
        String data=HttpUtils.sendGet(BaseUrls.URL_ZP_INFOS,map,false);
        return dto._data(getStatus(data),data);
    }
}
