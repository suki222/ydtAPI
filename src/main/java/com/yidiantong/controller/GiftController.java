package com.yidiantong.controller;

import com.yidiantong.bean.Testbean;
import com.yidiantong.dto.ResultData;
import com.yidiantong.service.GiftService;
import com.yidiantong.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 赠品接口
 */
@RestController
@RequestMapping(value="/gift")
public class GiftController {

	@Autowired
	private GiftService mService;
	@RequestMapping
	public String index(){
		return "赠品接口";
	}

	/**
	 * 获取赠品
	 * @return
     */
	@RequestMapping(value="getlist",method = RequestMethod.POST)
	public ResultData get() throws Exception {
		return mService.getGiftList();
	}
}
