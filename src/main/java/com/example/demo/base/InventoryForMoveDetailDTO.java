package com.example.demo.base;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/3/20 16:00
 */
@Data
public class InventoryForMoveDetailDTO {
    private Long id;

    private Long wrhId;

    private Long productId;

    private Long productSubId;

    private Long tenantId;
    private Integer stockNumber;

    private Integer inStockNumber;

    private Integer outStockNumber;

    private Integer occupyStockNumber;

    private Integer useableStockNumber;

    private Integer oversaleStockNumber;

    private Integer promotionsUseableNumber;

    private Date lastInTime;

    private Integer deleteStatus;

    private Long userId;

    private BigDecimal costPrice;
}

