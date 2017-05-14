package com.yidiantong.controller;

import com.yidiantong.dto.ResultData;
import com.yidiantong.service.BindService;
import com.yidiantong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 订单接口
 */
@RestController
@RequestMapping(value="/bind")
public class BindController {

	@Autowired
	private BindService mService;
	@RequestMapping
	public String index(){
		return "绑定接口";
	}


	/**
	 * 查询绑定信息
	 * openid 必填
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="getInfo",method = RequestMethod.POST)
	public ResultData get(@RequestBody Map params) throws Exception {
		return mService.getBindInfo(params.get("openid").toString());
	}

	/**
	 * 添加绑定
	 * openid 必填
	 * userid 必填
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="addBind",method = RequestMethod.POST)
	public ResultData add(@RequestBody Map params) throws Exception {
		return mService.addBind(params);
	}
}
