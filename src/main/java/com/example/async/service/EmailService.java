package com.example.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    //기본 Thread Pool로 동작한다.
    @Async("defaultTasKExecutor")
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }

    //messagingTasKExecutorf로 동작한다.
    @Async("messagingTasKExecutor")
    public void sendMailWithCustomThreadPool() {
        System.out.println("[messagingTasKExecutor] :: " + Thread.currentThread().getName());

    }

}
