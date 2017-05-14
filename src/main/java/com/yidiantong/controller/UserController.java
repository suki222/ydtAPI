package com.yidiantong.controller;

import com.yidiantong.dto.ResultData;
import com.yidiantong.service.GiftService;
import com.yidiantong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户接口
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService mService;
	@RequestMapping
	public String index(){
		return "用户相关接口";
	}

	/**
	 * 登录
	 * username 用户名
	 * password 密码
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ResultData login(@RequestBody Map params) throws Exception {
		return mService.login(params.get("username").toString(),params.get("password").toString());
	}

	/**
	 * 获取用户信息
	 * userid 必填
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="getUserInfo",method = RequestMethod.POST)
	public ResultData get(@RequestBody Map params) throws Exception{
		return mService.getUserInfo(params.get("userid").toString());
	}

	/**
	 * 获取用户数
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="getUserNum",method = RequestMethod.POST)
	public ResultData get() throws Exception{
		return mService.getUserNum();
	}
	/**
	 * 修改用户密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="resetPwd",method = RequestMethod.POST)
	public ResultData reset(@RequestBody Map params) throws Exception{
		System.out.println(params.toString());
		return mService.resetPwd(params);
	}

	/**
	 * 获取vip等级
	 * @param params
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="getVipType",method = RequestMethod.POST)
	public ResultData getvip(@RequestBody Map params) throws Exception{
		System.out.println(params.toString());
		return mService.getVipType(params.get("userid").toString());
	}
}
