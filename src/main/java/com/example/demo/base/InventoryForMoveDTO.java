package com.example.demo.base;

import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/3/25 17:08
 */
@Data
public class InventoryForMoveDTO {
    private Integer importType;
    private List<InventoryForMoveDetailDTO> list;
}
