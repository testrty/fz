package com.util;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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

        @Bean
    public MybatisSqlSessionFactoryBean sqlSession() {
        System.out.println("芜湖");
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        try {
            mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));//设置对应的xml文件地址
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        return mybatisSqlSessionFactoryBean;
    }


//    @Bean
//    public SqlSessionFactory sqlSession() {
//        System.out.println("芜湖");
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        try {
//            //设置对应的xml文件地址
//            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        SqlSessionFactory factory = null;
//        try {
//            factory = sqlSessionFactoryBean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return factory;
//    }
}

