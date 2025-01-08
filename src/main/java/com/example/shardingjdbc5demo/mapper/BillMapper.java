package com.example.shardingjdbc5demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbc5demo.domain.Bill;
import com.example.shardingjdbc5demo.domain.BillItem;
import com.example.shardingjdbc5demo.dto.StoreBillItemTotalResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 主账单明细表 Mapper 接口
 * </p>
 *
 * @author zbm
 * @since 2024-05-22
 */
@Mapper
public interface BillMapper extends BaseMapper<Bill> {

}
