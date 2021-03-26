package com.buyf.common.base.auto.configuration.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;

/**
 * @author buyf
 * @date 2021/2/22 16:33
 * @desc
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);
    @Override
    public void setEnvironment(Environment environment) {

    }
}
