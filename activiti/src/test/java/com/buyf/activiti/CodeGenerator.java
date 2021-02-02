package com.buyf.activiti;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
    private static String[] tableNames=new String[]{
            "sys_permission",
            "sys_role",
            "sys_role_permission",
            "sys_user",
            "sys_user_role",
    };
    private static String filePath = "D:\\generator2";
    private static String tablePre = "sys_";
    private static String url = "jdbc:mysql://192.168.17.138:3306/user-center?useUnicode=true&characterEncoding=utf-8";


    GlobalConfig gc = new GlobalConfig();
    DataSourceConfig dsc = new DataSourceConfig();
    PackageConfig pc = new PackageConfig();
    StrategyConfig strategy = new StrategyConfig();


    // 全局配置
    private void GlobalConfig(){
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(filePath);
        gc.setAuthor("buyf");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setDateType(DateType.ONLY_DATE);
    }
    // 数据源配置
    private void dataSourceConfig(){
        // 数据源配置
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
//        dsc.setTypeConvert(new MysqlTypeConvertCustom());
    }

    private void packageConfig(){
        // 包配置
        pc.setParent("com.buyf.activiti");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("dao");
        pc.setController("controller");
    }
    private void strategyConfig(){
        // 策略配置
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(tableNames);
        strategy.setSuperEntityClass("com.buyf.activiti.entity.BasicEntity");
        strategy.setSuperEntityColumns("id","created_time","updated_time");
        strategy.setTablePrefix(tablePre);
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
    }
    private void init(){
        GlobalConfig();
        dataSourceConfig();
        packageConfig();
        strategyConfig();

    }

    public void execute(){
        this.init();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.execute();
    }
}
