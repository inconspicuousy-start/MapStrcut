package com.inconspicuousy.mapstruct.definedmapper.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author peng.yi
 */
@Getter
@Setter
public class Person {

    // 用来测试fluent类型的get/set方法是否能映射成功
    // 注意: 源数据字段必须提供get方法, 不然获取不到数据
    // 目标数据字段才可以使用fluent类型赋值
    private String name;

    private Map<String, String> map;
}
