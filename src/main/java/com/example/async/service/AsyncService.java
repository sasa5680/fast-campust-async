package com.example.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    public void asyncCall_1(){
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        //현재 작업을 처리중인 Thread의 이름을 알아낸다.
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_2(){
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());

        //new 로 선언한 경우에도 async로 동작? 비동기로 동작하지 않는다.
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_3(){

        //비동기로 동작하지 않는다.
        //async 로 동작하기 위해서는 반드시 bean 주입을 받아야 한다.
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendMail();
    }

    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}
