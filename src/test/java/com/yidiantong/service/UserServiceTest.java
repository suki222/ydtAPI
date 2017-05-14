package com.yidiantong.service;

import com.yidiantong.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wujw on 17/5/2.
 */
public class UserServiceTest {

    @Autowired
    UserService mService=new UserServiceImpl();
    @Test
    public void testGetUserInfo() throws Exception {
        mService.getUserInfo("3503019999999662");
    }

    @Test
    public void testGetUserNum() throws Exception {
        mService.getUserNum();
    }

    @Test
    public void testLogin() throws Exception {
        mService.login("3505010000100121","qz_100121");
    }
}