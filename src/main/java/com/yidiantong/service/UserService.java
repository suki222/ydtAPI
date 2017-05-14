package com.yidiantong.service;

import com.yidiantong.dto.ResultData;
import com.yidiantong.dto.ResultDto;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * 用户相关接口
 * Created by wujw on 17/4/24.
 */
@Service
public interface UserService {
    /**
     * 根据id获取用户信息
     * @return
     */
    public ResultData getUserInfo(String userid) throws Exception;

    /**
     * 获取全部员工数目
     * @return
     * @throws Exception
     */
    public ResultData getUserNum() throws Exception;

    /**
     * 登录
     * @return
     * @throws Exception
     */
    public ResultData login(String username,String password) throws Exception;

    /**
     * 修改密码
     * @return
     */
    public ResultData resetPwd(Map params) throws JSONException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 获取用户VIP等级
     * @param userid
     * @return
     */
    public ResultData getVipType(String userid) throws Exception;

}
