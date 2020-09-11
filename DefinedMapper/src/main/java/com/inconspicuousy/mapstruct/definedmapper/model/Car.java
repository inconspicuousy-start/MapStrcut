package com.inconspicuousy.mapstruct.definedmapper.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * @author peng.yi
 */
@Getter
@Setter
public class Car {

    private String make;
    // 用来测试同属性名不同参数类型的属性映射情况
    private String name;
    // 用来测试不同属性名不同参数类型的属性映射情况
    private Integer numberOfSeats;
    // 用来测试非标准的JavaBean属性(Get方法不是以get开头)的属性属性映射情况
    // 这里生成的get方法直接以属性名为方法名, 导致映射失败, 找不到get方法
    @Accessors(chain = true, fluent = true)
    private String silenceSource;

    // 属性名相同, 类型会自动转换, 如果类型转换方法存在映射器中就会用映射器的类型转换方法
    private Person driver;

    // 测试Set转成List
    private Set<String> set;

}
