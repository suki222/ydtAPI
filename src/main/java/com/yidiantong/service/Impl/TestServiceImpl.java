package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseService;
import com.yidiantong.dao.TestDao;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试实现类
 * Created by wujw on 17/4/24.
 */
@Service
public class TestServiceImpl extends BaseService implements TestService{
    @Autowired
    private TestDao dao;
    @Override
    public ResultData getTest() throws ParseException {
        return dto._data(1,dao.queryById().toString(),"请求成功");
    }

    @Override
    public String apiTest() throws Exception {
        Map map=new HashMap<>();
//        String data=HttpUtils.sendGet(getURL(BaseUrls.URL_ZP_INFOS),map,false);
        return "";
    }
}
