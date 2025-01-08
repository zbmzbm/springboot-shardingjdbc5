package com.example.shardingjdbc5demo;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.shardingjdbc5demo.domain.Bill;
import com.example.shardingjdbc5demo.domain.BillItem;
import com.example.shardingjdbc5demo.domain.Employee;
import com.example.shardingjdbc5demo.domain.SubBillItem;
import com.example.shardingjdbc5demo.mapper.BillItemMapper;
import com.example.shardingjdbc5demo.mapper.BillMapper;
import com.example.shardingjdbc5demo.mapper.EmployeeMapper;
import com.example.shardingjdbc5demo.mapper.SubBillItemMapper;
import com.example.shardingjdbc5demo.service.BillItemService;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("self")
class ShardingJdbc5DemoApplicationTests {

    @Autowired
    private BillItemMapper billItemMapper;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SubBillItemMapper subBillItemMapper;

    @Autowired
    private BillItemService billItemService;

    @Test
    public void testBatchSave() {
        List<BillItem> billItems=new ArrayList<BillItem>();
        for (int i = 0; i < 4; i++) {
            BillItem billItem=new BillItem();
            billItem.setBillNo("661000"+i);
            billItem.setBillRange("2024-06-01 00:00:00");
            billItem.setConfirmTime(new Date());
            billItem.setStatus(0);
            billItem.setErrorStatus(0);
            billItem.setIsDelete(0);
            billItem.setTransactionId("1");
            billItem.setTransactionType(0);
            billItem.setChannelType(1L);
            billItems.add(billItem);
        }
        billItemService.saveBatch(billItems);
    }

    @Test
    public void testSubBillItem() {
        SubBillItem subBillItem=new SubBillItem();
        subBillItem.setDetailNo("620012012");
        subBillItemMapper.insert(subBillItem);
    }

    @Test
    @Transactional
    public void setEmployeeMapper() {
        //没有进行分库分表的
        Employee employee=new Employee();
        employee.setAge(30);
        employee.setName("ww");
        employeeMapper.insert(employee);
        int a=10/0;
    }

    @Test
    public void getEmployeeMapper() {
        //没有进行分库分表的
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);

    }

    @Test
    public void contextLoads() {
        BillItem billItem=new BillItem();
        billItem.setBillNo("33100001");
        billItem.setBillRange("2024-06-01 00:00:00");
        billItem.setConfirmTime(new Date());
        billItem.setStatus(0);
        billItem.setErrorStatus(0);
        billItem.setIsDelete(0);
        billItem.setTransactionId("1");
        billItem.setTransactionType(0);
        billItem.setChannelType(1L);
        billItemMapper.insert(billItem);

    }

    @Test
    public void contextLoads2() {
        List<Bill> bills = billMapper.selectList(Wrappers.<Bill>lambdaQuery().eq(Bill::getBillNo, "666"));
        System.out.println(bills);
    }

    @Test
    public void testRange() {
        for (int i = 0; i < 10000; i++) {
            BillItem billItem=new BillItem();
            Long idStr = IdUtil.getSnowflakeNextId();

            String numberStr = Long.toString(idStr);
            int length = numberStr.length();
            billItem.setBillNo(numberStr.substring(length - 1));
            billItem.setBillRange("2024-06-01 00:00:00");
            billItem.setConfirmTime(new Date());
            billItem.setStatus(0);
            billItem.setErrorStatus(0);
            billItem.setIsDelete(0);
            billItem.setTransactionId("1");
            billItem.setTransactionType(0);
            billItem.setChannelType(Long.valueOf(numberStr.substring(length - 2, length - 1)));
            billItemMapper.insert(billItem);
        }
    }

    public static void testLong(Long number){
        // 将Long类型转换为字符串
        String numberStr = Long.toString(number);

        // 获取倒数第二位和倒数第三位
        int length = numberStr.length();
        String substring = numberStr.substring( length - 1);

        System.out.println(Long.valueOf(numberStr.substring(length - 2, length - 1)));
    }

    public static void main(String[] args) {
        testLong(123456L);
    }

}
