package com.yidiantong.controller;

import com.yidiantong.bean.WXeventbean;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.GiftService;
import com.yidiantong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 订单接口
 */
@RestController
@RequestMapping(value="/order")
public class OrderController {

	@Autowired
	private OrderService mService;
	@RequestMapping
	public String index(){
		return "订单接口";
	}

	/**
	 * 获取订单信息
	 * userid 必填
	 * @param params
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="getList",method = RequestMethod.POST)
	public ResultData get(@RequestBody Map params) throws Exception {
		return mService.getOrderList(params.get("userid").toString());
	}

	/**
	 * 提交订单信息
	 * userid 必填
	 * @param params
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value="addOrder",method = RequestMethod.POST)
	public ResultData add(@RequestBody Map params) throws Exception {
		return mService.addOrderList(params);
	}
}
