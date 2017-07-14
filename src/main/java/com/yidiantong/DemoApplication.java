package com.yidiantong;

import com.yidiantong.base.BaseService;
import com.yidiantong.base.BaseUrls;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.yidiantong.dao")
public class DemoApplication{
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
