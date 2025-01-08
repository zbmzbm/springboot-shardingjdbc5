package com.example.shardingjdbc5demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zbm
 * @date 2024/5/2819:36
 */
@Data
public class CheckBillStoreNoDTO implements Serializable {

    private String storeNo;

    private BigDecimal totalAmount;
}
