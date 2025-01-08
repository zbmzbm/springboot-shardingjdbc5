package com.example.shardingjdbc5demo.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shardingjdbc5demo.domain.BillItem;
import com.example.shardingjdbc5demo.mapper.BillItemMapper;
import com.example.shardingjdbc5demo.service.BillItemService;
import org.springframework.stereotype.Service;

@Service
public class BillItemServiceImpl extends ServiceImpl<BillItemMapper, BillItem> implements BillItemService {
}
