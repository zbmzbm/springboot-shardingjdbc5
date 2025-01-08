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
 * 子账单明细表
 * </p>
 *
 * @author zbm
 * @since 2024-05-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sub_bill_item")
public class SubBillItem extends Model<SubBillItem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 明细编号
     */
    @TableField("detail_no")
    private String detailNo;

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

    public static final String DETAIL_NO = "detail_no";

    public static final String SUB_BILL_NO = "sub_bill_no";

    public static final String OUT_NO = "out_no";

    public static final String OUT_OTHER_NO = "out_other_no";

    public static final String OUT_STORE_NO = "out_store_no";

    public static final String STORE_NO = "store_no";

    public static final String STORE_NAME = "store_name";

    public static final String ACTUAL_AMOUNT = "actual_amount";

    public static final String STATUS = "status";

    public static final String OTHER_INSTRUCTION = "other_instruction";

    public static final String BUSINESS_INCOME = "business_income";

    public static final String BUSINESS_SUBSIDY = "business_subsidy";

    public static final String HANDLING_FEE = "handling_fee";

    public static final String ASSIGN_TIME = "assign_time";


    @Override
    public Serializable pkVal() {
        return this.id;
    }
}