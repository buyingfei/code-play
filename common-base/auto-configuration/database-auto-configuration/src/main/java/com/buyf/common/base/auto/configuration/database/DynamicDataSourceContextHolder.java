package com.buyf.common.base.auto.configuration.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }
    public static String getDataSourceType(){
        return contextHolder.get();
    }

    public static void cleanDataSourceType(){
        contextHolder.remove();
    }

}
