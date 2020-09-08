package com.inconspicuousy.mapstruct.start.dto;

import lombok.Data;

/**
 * 汽车数据展示对象
 * @author peng.yi
 */
@Data
public class CarDto {

    /** 汽车生产商 */
    private String make;

    /** 座位数 */
    private Integer seatCount;

    /** 汽车类型 */
    private String type;

}
