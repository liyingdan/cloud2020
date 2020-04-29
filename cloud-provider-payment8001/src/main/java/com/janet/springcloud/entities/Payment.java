package com.janet.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @Description TODO
 * @Date 2020/4/29
 * @Author Janet
 *
 *  加上序列化，后面分布式部署会用得到
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