package com.yidiantong.service;

import com.yidiantong.base.BaseService;
import com.yidiantong.dao.TestDao;
import com.yidiantong.dto.ResultData;
import com.yidiantong.dto.ResultDto;
import com.yidiantong.enums.BaseCode;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ResultData getTest();

    /**
     *
     * @return
     * @throws Exception
     */
    public String apiTest() throws Exception;
}
