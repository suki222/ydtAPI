package com.yidiantong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wujw on 17/5/2.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GiftServiceTest {

    @Autowired
    GiftService mService;
    @Test
    public void testGetGiftList() throws Exception {
        mService.getGiftList();
    }
}