package com.buyf.deploy.user.center.aspect;


import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(org.springframework.http.ResponseEntity<com.pingan.pah.ehis.user.common.response.ResponseDto> com.pingan.pah.ehis.usercenter.*.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        //获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //如果有上层调用就用上层的ID
        String traceId = request.getHeader(WebConstant.WEB_REQUEST_ID);
        if (traceId == null) {
            traceId = UUID.randomUUID().toString().toLowerCase().replace("-","");
        }
        MDC.put(WebConstant.WEB_REQUEST_ID, traceId);
    }

    @AfterReturning(returning = "obj", pointcut = "webLog()")
    public Object doAfterReturning(JoinPoint joinPoint ,Object obj) {
        try {
            //如果有上层调用就用上层的ID
            String traceId = MDC.get(WebConstant.WEB_REQUEST_ID);
            if (StringUtils.isNotEmpty(traceId)) {
                ResponseEntity<ResponseDto> response = (ResponseEntity<ResponseDto>) obj;
                ResponseDto body = response.getBody();
                body.setRequestId(traceId);
            }
        }catch (Exception e){
            log.info("doAfterReturning exception",e);
        }

        return obj;
    }

}
