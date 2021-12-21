package com.buyf.deploy.user.center.config;

import org.slf4j.MDC;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
//@Slf4j
public class AsyncConfiguration extends AsyncConfigurerSupport {

    public AsyncConfiguration() {
        super();
    }

    @Bean
    public ThreadPoolTaskExecutor asyncExecutor() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxCorePoolSize = Runtime.getRuntime().availableProcessors()*2+1;
        ThreadPoolTaskExecutor threadPool = new UserThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(corePoolSize);
        threadPool.setMaxPoolSize(maxCorePoolSize);
        threadPool.setKeepAliveSeconds(60);
        threadPool.setQueueCapacity(200);
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        threadPool.setThreadNamePrefix("async-thread-pool-");
        threadPool.initialize();
//        log.info("UserThreadPoolTaskExecutor CorePoolSize=[{}],MaxPoolSize=[{}]",corePoolSize,maxCorePoolSize);
        return threadPool;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return super.getAsyncUncaughtExceptionHandler();
    }


    class UserThreadPoolTaskExecutor extends ThreadPoolTaskExecutor{
        @Override
        public void execute(Runnable task) {
//            super.execute(task);
            super.execute(wrap(task,MDC.getCopyOfContextMap()));
        }

        @Override
        public void execute(Runnable task, long startTimeout) {
//            super.execute(task, startTimeout);
            super.execute(wrap(task,MDC.getCopyOfContextMap()),startTimeout);
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task,MDC.getCopyOfContextMap()));
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            return super.submit(wrap(task,MDC.getCopyOfContextMap()));
        }

        private  Runnable wrap(final Runnable runnable, final Map<String, String> context) {
            return () -> {
                Map<String, String> previous = MDC.getCopyOfContextMap();
                if (context == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(context);
                }
                try {
                    runnable.run();
                } finally {
                    if (previous == null) {
                        MDC.clear();
                    } else {
                        MDC.setContextMap(previous);
                    }
                }
            };
        }

        private  <T> Callable<T> wrap(final Callable<T> task, final Map<String, String> context) {
            return () -> {
                Map<String, String> previous = MDC.getCopyOfContextMap();
                if (context == null) {
                    MDC.clear();
                } else {
                    MDC.setContextMap(context);
                }
                try {
                    return task.call();
                } finally {
                    if (previous == null) {
                        MDC.clear();
                    } else {
                        MDC.setContextMap(previous);
                    }
                }
            };
        }
    }
}

