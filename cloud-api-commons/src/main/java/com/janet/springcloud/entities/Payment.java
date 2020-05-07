package com.janet.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Janet
 * @date 2020/4/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    //主键
    private Long id;  // 建表的时候用的 BIGINT

    //支付流水号
    private String  serial;

}
