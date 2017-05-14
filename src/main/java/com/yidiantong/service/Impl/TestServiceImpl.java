package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import com.yidiantong.dao.TestDao;
import com.yidiantong.dto.ResultData;
import com.yidiantong.enums.BaseCode;
import com.yidiantong.service.TestService;
import com.yidiantong.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ResultData getTest() {
//        if(dao.queryById()==null){
//            return dto._data(BaseCode.ERROR,dao.queryById());
//        }else{
//            return dto._data(BaseCode.SUCCESS,dao.queryById());
//        }
        return new ResultData();
    }

    @Override
    public String apiTest() throws Exception {
        Map map=new HashMap<>();
        String data=HttpUtils.sendGet(BaseUrls.URL_ZP_INFOS,map,false);
        return data;
    }
}
