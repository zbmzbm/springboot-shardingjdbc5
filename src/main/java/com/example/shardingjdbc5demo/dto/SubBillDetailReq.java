package com.example.shardingjdbc5demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zbm
 * @date 2024/6/311:09
 */
@Data
public class SubBillDetailReq implements Serializable {


    private Integer pageNum;

    private Integer pageSize;

    private String billRange;
    private Long maxId;

    /**
     * 批次id,选择单条批次的时候
     */
    private Long batchId;
    /**
     * 子账单编号
     */
    private Long taskId;

    /**
     * 明细编号
     */
    private String detailNo;

    /**
     * 渠道门店编号
     */
    private String outStoreNo;

    /**
     * 门店名称
     */
    private String outStoreName;

    private List<String> storeIds;
    /**
     * 实际金额
     */
    private BigDecimal actualAmount;
    /**
     * 交易开始时间
     */
    private Date tradeBeginTime;
    /**
     * 交易结束时间
     */
    private Date tradeEndTime;
    /**
     * 第三方订单号
     */
    private String outOrderNo;
    /**
     * 三方其他编号
     */
    private String outOtherNo;
    /**
     *
     * null-全部，1-中断（待处理），2-正常分账，3-异常明细
     */
    private Integer status;


}
