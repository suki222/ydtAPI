package com.yidiantong.service;

import com.yidiantong.service.Impl.TestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wujw on 17/5/2.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Autowired
    TestService mService;
    @Test
    public void testApiTest() throws Exception {
        System.out.println("========data=========="+mService.apiTest());
    }
}