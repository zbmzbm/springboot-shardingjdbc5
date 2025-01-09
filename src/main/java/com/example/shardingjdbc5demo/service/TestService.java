package com.example.shardingjdbc5demo.service;

import com.example.shardingjdbc5demo.domain.Bill;
import com.example.shardingjdbc5demo.domain.BillItem;
import com.example.shardingjdbc5demo.domain.SubBillItem;
import com.example.shardingjdbc5demo.mapper.BillItemMapper;
import com.example.shardingjdbc5demo.mapper.BillMapper;
import com.example.shardingjdbc5demo.mapper.SubBillItemMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    private BillItemMapper billItemMapper;
    @Autowired
    private SubBillItemMapper subBillItemMapper;
    @Autowired
    private BillMapper billMapper;

    public void testInsert(){
        TestService testService= (TestService)AopContext.currentProxy();
        testService.testAop();

    }
    @Transactional
    public void testAop() {
        SubBillItem subBillItem=new SubBillItem();
        subBillItem.setDetailNo("620012000");
        subBillItemMapper.insert(subBillItem);
        BillItem billItem=new BillItem();
        billItem.setBillNo("620012010");
        billItem.setBillRange("2024-06-01 00:00:00");
        billItem.setConfirmTime(new Date());
        billItem.setStatus(0);
        billItem.setErrorStatus(0);
        billItem.setIsDelete(0);
        billItem.setTransactionId("1");
        billItem.setTransactionType(0);
        billItem.setChannelType(1L);
        billItemMapper.insert(billItem);
        //int a=10/0;
    }

   /* public static void main(String[] args) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        Map<Integer,Integer> set=new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String snowflakeNextIdStr = IdUtil.getSnowflakeNextIdStr();
            String s = StringCommonUtils.tail4(snowflakeNextIdStr);
            Integer a = Integer.valueOf(s.substring(2));
            Integer b = Integer.valueOf(s.substring(0,2));
            //System.out.println(snowflakeNextIdStr+":"+a+":"+b);
            Integer c=a%16;
            Integer d=b%32;
            set.put(d,c);
            //System.out.println(a%16+":"+b%32);
            map.put(c,set);
        }
        System.out.println(map);
    }*/
}
