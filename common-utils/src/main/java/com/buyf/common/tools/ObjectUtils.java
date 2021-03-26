package com.buyf.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;

public class ObjectUtils {
    private final static Logger log = LoggerFactory.getLogger(JsonUtils.class);
    public static <S,D> void cglibCopyProperties(S source,D desc){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), desc.getClass(),false);
        beanCopier.copy(source,desc,null);
    }

    public static <S,D> D cglibCopyProperties(S source,Class<D> descClass){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), descClass,false);
        D d = null;
        try {
            d = descClass.newInstance();
        }catch (Exception e) {
            log.error("{}",e);
        }
        beanCopier.copy(source,d,null);
        return d;
    }
}
