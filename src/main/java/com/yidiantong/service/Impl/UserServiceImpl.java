package com.yidiantong.service.Impl;

import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.GiftService;
import com.yidiantong.service.UserService;
import com.yidiantong.utils.HttpUtils;
import com.yidiantong.utils.MD5Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 赠品实现类
 * Created by wujw on 17/4/24.
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    private Map map;

    @Override
    public ResultData getUserInfo(String userid) throws Exception {
        map=new HashMap<>();
        map.put("id",userid);
        String data=HttpUtils.sendGet(BaseUrls.URL_USER00,map,false);
        return dto._data(getStatus(data),data);
    }

    @Override
    public ResultData getUserNum() throws Exception {
        map=new HashMap<>();
        String data=HttpUtils.sendGet(BaseUrls.URL_USER00_LIST,map,false);
        return dto._data(getStatus(data),data);
    }

    @Override
    public ResultData login(String username,String password) throws Exception {
        map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        String data=HttpUtils.sendPost(BaseUrls.URL_USER00_LOGIN,map);
        JSONObject obj=new JSONObject(data);
        if(obj.optBoolean("flag")){
            //登录成功,返回用户信息
            map=new HashMap<>();
            map.put("id",username);
            data=HttpUtils.sendGet(BaseUrls.URL_USER00,map,false);
        };
        return dto._data(getStatus(data),data);
    }

    @Override
    public ResultData resetPwd(Map params) throws JSONException, UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject obj=new JSONObject();
        obj.put("userid",params.get("userid").toString());
        obj.put("passwd", MD5Util.EncoderByMd5(params.get("passwd").toString()));
        String data=HttpUtils.sendJsonPut(BaseUrls.URL_USER00,obj);
        return dto._data(getStatus(data),data);
    }

    @Override
    public ResultData getVipType(String userid) throws Exception {
        map=new HashMap<>();
        map.put("userid",userid);
        String data=HttpUtils.sendGet(BaseUrls.URL_DDB000_LIST,map,false);
        String data_="10";
        if(!data.isEmpty()){
            //获取最后一条订单的vip等级
            JSONArray array=new JSONArray(data);
            JSONObject obj=array.getJSONObject(0);
            data_=obj.optString("viptype");
        }
        if(data_.equals("null")){
            data_="10";
        }
        return dto._data(getStatus(data),data_==null?"10":data_);
    }

}
