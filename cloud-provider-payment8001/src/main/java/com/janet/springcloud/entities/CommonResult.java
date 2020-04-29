package com.janet.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Json 封装体
 * @Date 2020/4/29
 * @Author Janet
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    // data 有时候可能为空 （全参构造方法上面的注解已经实现了）
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}