package com.yidiantong.dao;

import com.yidiantong.entity.Testbean;

/**
 * dao 数据库连接层
 * Created by wujw on 17/4/21.
 */
public interface TestDao {
    Testbean queryById();
}
