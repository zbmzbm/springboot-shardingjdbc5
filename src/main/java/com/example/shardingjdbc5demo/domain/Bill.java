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
 * 主账单表
 * </p>
 *
 * @author zbm
 * @since 2024-05-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("bill")
public class Bill extends Model<Bill> {

    private static final long serialVersionUID = 1L;

    /**
     * 账单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账单编号
     */
    @TableField("bill_no")
    private String billNo;

    /**
     * 0：创建；1：生效；2：异常；9：全部分账结束
     */
    @TableField("status")
    private Integer status;

    /**
     * 渠道类型，1:2024年520活动
     */
    @TableField("channel_type")
    private Integer channelType;

    /**
     * 账单周期开始，示例：20240401
     */
    @TableField("period_start")
    private String periodStart;

    /**
     * 账单周期结束，示例：20240401
     */
    @TableField("period_end")
    private String periodEnd;

    /**
     * 账单金额，单位分
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 处理流程，数据示例：1,2,4
     */
    @TableField("deal_process")
    private String dealProcess;

    /**
     * 通知模版ID
     */
    @TableField("notify_template_id")
    private String notifyTemplateId;

    /**
     * 账单生成规则编号
     */
    @TableField("rule_no")
    private String ruleNo;

    /**
     * 0:无中断  1:有中断
     */
    @TableField("is_interrupt")
    private Integer isInterrupt;

    /**
     * 0：未开始处理/全部生成子账单；1：待处理
     */
    @TableField("is_pending")
    private Integer isPending;

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

    public static final String BILL_NO = "bill_no";

    public static final String STATUS = "status";

    public static final String TYPE = "type";

    public static final String PERIOD = "period";

    public static final String AMOUNT = "amount";

    public static final String FLOW = "flow";

    public static final String RULE_NO = "rule_no";


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
