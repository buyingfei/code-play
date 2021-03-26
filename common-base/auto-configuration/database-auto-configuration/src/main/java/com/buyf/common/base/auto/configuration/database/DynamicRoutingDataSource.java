package com.buyf.common.base.auto.configuration.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author buyf
 * @date 2021/2/22 16:44
 * @desc
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    /**
     *当前类托管给spring 为单例，需要通过threadLocal 保证线程安全
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
