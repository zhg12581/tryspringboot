package com.example.config;

/**
 * @author zhu
 * @date 2019/9/21
 **/

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.dao")
public class MyBatisConfig {
}
