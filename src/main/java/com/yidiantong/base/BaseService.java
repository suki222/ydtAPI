package com.yidiantong.base;

import com.yidiantong.dto.ResultDto;
import org.springframework.beans.factory.annotation.Value;

/**
 * 业务逻辑层基类
 * Created by wujw on 17/4/24.
 */
public class BaseService {
    @Value("${url.base}")
    private String baseUrl;

    public ResultDto dto=new ResultDto();//数据返回工具类

    /**
     * 解释一下,baseurl放在配置文件里,BaseUrls.class我没找到拿的方法,所以,这边添加baseurl
     * @param url
     * @return
     */
    public String getURL(String url){
        return baseUrl+url;
    }
}
