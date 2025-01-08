package com.example.shardingjdbc5demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 主账单明细表
 * </p>
 *
 * @author zbm
 * @since 2024-05-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("bill_item")
public class BillItem extends Model<BillItem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账单月份,格式202405
     */
    @TableField("bill_range")
    private String billRange;

    /**
     * 账单编号
     */
    @TableField("bill_no")
    private String billNo;

    /**
     * 账单活动类型-与channelType一致
     */
    private Long channelType;

    /**
     * 外部唯一事务ID
     */
    private String transactionId;

    /**
     * 第三方订单号
     */
    @TableField("out_order_no")
    private String outOrderNo;

    /**
     * 渠道门店编码
     */
    @TableField("out_store_no")
    private String outStoreNo;

    /**
     * 渠道门店名称
     */
    @TableField("out_store_name")
    private String outStoreName;

    /**
     * 门店编号
     */
    @TableField("store_no")
    private String storeNo;

    /**
     * 交易时间
     */
    @TableField("transaction_time")
    private Date transactionTime;


    /**
     * 交易类型；1.核销；2反核销
     */
    private Integer transactionType;

    /**
     * 消费券码
     */
    @TableField("coupon_code")
    private String couponCode;

    /**
     * 消费券模版ID
     * 三方其他编号
     */
    @TableField("out_other_no")
    private String outOtherNo;

    /**
     * 消费券模版名称
     * 其他说明
     */
    @TableField("remark")
    private String remark;

    /**
     * 第三方账单金额
     */
    @TableField("transaction_amount")
    private BigDecimal transactionAmount;

    /**
     * 实际到账金额
     */
    @TableField("actual_amount")
    private BigDecimal actualAmount;

    /**
     * 营业收入
     */
    private BigDecimal incomeFee;

    /**
     * 补贴金额
     */
    private BigDecimal subsidyFee;

    /**
     * 手续费
     */
    private BigDecimal handlingFee;

    /**
     * 0：未生成主账单；1：主账单生成/未通知；2：已通知；3：已确认；4：已开票；8：子账单流程进行中；9：分账结束
     */
    @TableField("status")
    private Integer status;

    /**
     * 0：无异常；1：钱包未开户
     */
    @TableField("error_status")
    private Integer errorStatus;

    /**
     * 通知时间
     */
    @TableField("notice_time")
    private Date noticeTime;

    /**
     * 确认时间
     */
    @TableField("confirm_time")
    private Date confirmTime;

    /**
     * 开票时间
     */
    @TableField("invoice_time")
    private Date invoiceTime;

    /**
     * 分账时间
     */
    @TableField("assign_time")
    private Date assignTime;

    /**
     * 逻辑删除标记
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createAt;

    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private Date updateAt;



    public static final String ID = "id";

    public static final String BILL_RANGE = "bill_range";

    public static final String BILL_NO = "bill_no";

    public static final String OUT_NO = "out_no";

    public static final String OUT_STORE_NO = "out_store_no";

    public static final String STORE_NO = "store_no";

    public static final String STORE_NAME = "store_name";

    public static final String DEAL_TIME = "deal_time";

    public static final String COUPON_CODE = "coupon_code";

    public static final String AMOUNT = "amount";

    public static final String AMOUNT_INFO = "amount_info";

    public static final String STATUS = "status";

    public static final String ERROR_STATUS = "error_status";

    public static final String NOTICE_TIME = "notice_time";

    public static final String CONFIRM_TIME = "confirm_time";

    public static final String INVOICE_TIME = "invoice_time";

    public static final String ASSIGN_TIME = "assign_time";


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
