package com.son.config;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

public class MainAutomaticGeneration {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
//            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        //创建generator对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://192.168.1.121:3306/testBygo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("mysql");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);


        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 工程的绝对路径+下面的目录,根据自己的路径修改    com.md.mybatisplus
      //  globalConfig.setOutputDir(System.getProperty("user.dir")+"/mybatisplusauto/src/main/java");
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/mybatisplusauto/src/main/java");
        globalConfig.setOpen(false);
        globalConfig.setAuthor("md");
        globalConfig.setServiceName("%sService");
        autoGenerator.setGlobalConfig(globalConfig);


        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.md.mybatisplus");  //这里会分三层
        // 生成的module
        packageConfig.setModuleName(scanner("模块名："));

        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        autoGenerator.setPackageInfo(packageConfig);


        //配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        // 自动添加Lombok注解
        strategyConfig.setEntityLombokModel(true);
        // 数据库中的下划线改驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 可以指定表名
        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
        autoGenerator.setStrategy(strategyConfig);


        autoGenerator.execute();
    }
}
