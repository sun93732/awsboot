package com.example.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class MyController {

    @PostMapping("/test1")
    public ResponseEntity<String> handlePostRequest(@RequestBody Person attachForm) {
        // 处理接收到的Person对象的业务逻辑
        String responseMessage = "成功接收并处理了Person对象。";
        Person p = new Person();

        // 可以设置特定的HTTP状态码和响应内容
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
}
