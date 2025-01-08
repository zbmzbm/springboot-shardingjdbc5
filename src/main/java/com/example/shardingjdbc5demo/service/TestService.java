package com.example.shardingjdbc5demo.service;

import com.example.shardingjdbc5demo.domain.Bill;
import com.example.shardingjdbc5demo.domain.BillItem;
import com.example.shardingjdbc5demo.mapper.BillItemMapper;
import com.example.shardingjdbc5demo.mapper.BillMapper;
import com.example.shardingjdbc5demo.mapper.SubBillItemMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        BillItem billItem=new BillItem();
        billItem.setBillNo("55555");
        billItem.setBillRange("202405");
        billItem.setStatus(0);
        billItem.setErrorStatus(0);
        billItem.setIsDelete(0);
        billItem.setTransactionId("0");
        billItem.setTransactionType(0);
        billItem.setChannelType(1L);
        billItemMapper.insert(billItem);
        Bill bill=new Bill();
        bill.setBillNo("6666");
        bill.setChannelType(0);
        bill.setStatus(0);
        billMapper.insert(bill);
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
