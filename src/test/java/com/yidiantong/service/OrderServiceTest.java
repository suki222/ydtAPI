package com.yidiantong.service;

import com.yidiantong.service.Impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wujw on 17/5/2.
 */
public class OrderServiceTest {
    OrderService mService=new OrderServiceImpl();
    @Test
    public void testGetOrderList() throws Exception {
        mService.getOrderList("3503019999999662");
    }
    @Test
    public void testAddOrderList() throws Exception {
//        Map map=new HashMap<>();
//        map.put("userid","3503019999999662");
//        mService.addOrderList(map);
    }
}