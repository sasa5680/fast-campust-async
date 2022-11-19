package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
public class AppConfig {

    //ThreadPoolExecutor 정의
    @Bean(name="defaultTasKExecutor")
    public ThreadPoolTaskExecutor defaultThreadPoolTaskExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200); //최소의 Thread 수
        executor.setMaxPoolSize(300); //최대의 Thread 수

        return executor;
    }

    @Bean(name="messagingTasKExecutor")
    public ThreadPoolTaskExecutor messagingThreadPoolTaskExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200); //최소의 Thread 수
        executor.setMaxPoolSize(300); //최대의 Thread 수

        return executor;
    }
}
