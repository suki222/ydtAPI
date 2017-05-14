package com.yidiantong.controller;

import java.util.HashMap;
import java.util.Map;

import com.yidiantong.bean.Testbean;
import com.yidiantong.dao.TestDao;
import com.yidiantong.dto.ResultData;
import com.yidiantong.enums.BaseCode;
import com.yidiantong.service.Impl.TestServiceImpl;
import com.yidiantong.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 接口层测试
 */
@RestController
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	private TestService mService;
	@RequestMapping
	public String index(){
		return "hello world";
	}

	/**
	 * 测试demo1
	 * @return
     */
	@RequestMapping(value="get",method = RequestMethod.POST)
	public ResultData get(){
		return mService.getTest();
	}

	/**
	 * 测试demo2
	 * @param name
	 * @return
     */
	@RequestMapping(value="get")
	public ResultData get(@RequestParam String name){
		return mService.getTest();
	}

	/**
	 * 测试demo3
	 * @param id
	 * @param name
     * @return
     */
	@RequestMapping(value="find/{id}/{name}",method = RequestMethod.POST)
	public ResultData get(@PathVariable int id, @PathVariable String name){
		return mService.getTest();
	}

	@RequestMapping(value="query",method = RequestMethod.POST)
	public Testbean query(){
		Testbean bean=new Testbean();
		bean.setDQMC00("aaa");
		bean.setSSZX00("bbbb");
		return bean;
	}
}
