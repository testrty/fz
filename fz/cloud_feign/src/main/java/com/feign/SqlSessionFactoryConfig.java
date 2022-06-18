package com.feign;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author: gfd
 * @Description:
 * @FileName: SqlSessionFactoryConfig
 * @Date: 2021/5/26 16:48
 * @Version: 1.0
 */
@Configuration
public class SqlSessionFactoryConfig {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

//    @Bean
//    public MybatisSqlSessionFactoryBean sqlSession() {
//        System.out.println("芜湖");???
//        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        try {
//            mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));//设置对应的xml文件地址
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
//        return mybatisSqlSessionFactoryBean;
//    }
}

