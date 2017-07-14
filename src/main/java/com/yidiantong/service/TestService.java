package com.yidiantong.service;

import com.yidiantong.dto.ResultData;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * 业务逻辑测试
 * Created by wujw on 17/4/24.
 */
@Service
public interface TestService{

    /**
     * 测试
     * @return
     */
    public ResultData getTest() throws ParseException;

    /**
     *
     * @return
     * @throws Exception
     */
    public String apiTest() throws Exception;
}
