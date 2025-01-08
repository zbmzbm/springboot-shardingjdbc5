package com.example.shardingjdbc5demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@TableName("employee")
public class Employee extends Model<BillItem> {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;
}
