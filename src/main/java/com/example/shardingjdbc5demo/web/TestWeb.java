package com.example.shardingjdbc5demo.web;

import com.example.shardingjdbc5demo.mapper.BillItemMapper;
import com.example.shardingjdbc5demo.mapper.SubBillItemMapper;
import com.example.shardingjdbc5demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWeb {

    @Autowired
    private TestService testService;

    @GetMapping("/sharding/test")
    public void testInsert(){
        testService.testInsert();
    }
}
