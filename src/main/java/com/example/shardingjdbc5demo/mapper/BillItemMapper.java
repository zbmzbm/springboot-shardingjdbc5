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
public interface BillItemMapper extends BaseMapper<BillItem> {

    @Select("select sum(actual_amount) from bill_item where bill_range >= #{rangeStart} and bill_range <= #{rangeEnd} and DATE_FORMAT(transaction_time, '%Y%m%d') >= #{periodStart} and DATE_FORMAT(transaction_time, '%Y%m%d') <= #{periodEnd} and bill_no = #{billNo}")
    BigDecimal selectAmountByBillNo(String billNo, String rangeStart, String rangeEnd, String periodStart, String periodEnd);

    /**
     * 根据账单状态分页获取门店账单明细

     * @param billNo
     * @param periodStart
     * @param periodEnd
     * @return
     */
    List<StoreBillItemTotalResp> getListData(@Param(value = "billNo") String billNo, @Param(value = "periodStart") String periodStart,@Param(value = "periodEnd") String periodEnd, @Param(value = "status") Integer status);

    /**
     * 获取
     */


    /**
     * 批量获取已确认主账单明细
     * @param startPageSize
     * @param pageSize
     * @param billNo
     * @param periodStart
     * @param status
     * @return
     */
    List<BillItem> getConfirmBill(@Param("startPageSize")Integer startPageSize, @Param("pageSize")Integer pageSize,  @Param("billNo")String billNo, @Param("periodStart")String periodStart,@Param("status")Integer status);


    /**
     * 获取分页id
     *
     * @param startPageSize
     * @param
     * @param status
     * @return
     */
    Long getLimitId(@Param("startPageSize") Integer startPageSize,@Param("periodStart") String periodStart,@Param("periodEnd")String periodEnd, @Param("bill") Bill bill, @Param("status") Integer status);

    /**
     * 根据分页查询主账单明细
     * @param
     * @param limitId
     * @param pageSize
     * @param status
     * @return
     */
    List<StoreBillItemTotalResp> selectListGroupByPage(@Param("periodStart") String periodStart, @Param("periodEnd")String periodEnd, @Param("bill") Bill bill, @Param("limitId") Long limitId, @Param("pageSize") Integer pageSize, @Param("status")  Integer status);
}
