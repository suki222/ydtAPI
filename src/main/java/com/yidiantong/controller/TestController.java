package com.yidiantong.controller;

import java.text.ParseException;

import com.yidiantong.entity.Testbean;
import com.yidiantong.dto.ResultData;
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

	@RequestMapping(value="getDemo",method = RequestMethod.POST)
	public ResultData getDemo() throws ParseException {
		return mService.getTest();
	}

	/**
	 * 测试demo1
	 * @return
     */
	@RequestMapping(value="get",method = RequestMethod.POST)
	public ResultData get() throws ParseException {
		return mService.getTest();
	}

	/**
	 * 测试demo2
	 * @param name
	 * @return
     */
	@RequestMapping(value="get")
	public ResultData get(@RequestParam String name) throws ParseException {
		return mService.getTest();
	}

	/**
	 * 测试demo3
	 * @param id
	 * @param name
     * @return
     */
	@RequestMapping(value="find/{id}/{name}",method = RequestMethod.POST)
	public ResultData get(@PathVariable int id, @PathVariable String name) throws ParseException {
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
