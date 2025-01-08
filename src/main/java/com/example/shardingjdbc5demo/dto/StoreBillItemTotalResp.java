package com.example.shardingjdbc5demo.dto;

import com.example.shardingjdbc5demo.domain.BillItem;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 门店账单明细汇总
 *
 * @author YYL
 * @version 1.0.0
 * @date 2024-05-28 13:57
 */
@Data
public class StoreBillItemTotalResp extends BillItem {



    /**
     * 实际收款总额
     */
    private BigDecimal totalActualAmount;

    /**
     * 明细数量
     */
    private Integer count;

    /**
     * 营业收入总金额
     */
    private BigDecimal totalIncomeFee;

    /**
     * 营业补贴总金额
     */
    private BigDecimal totalSubsidyFee;

    /**
     * 平台手续费总金额
     */
    private BigDecimal totalHandlingFee;


}
