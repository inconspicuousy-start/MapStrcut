package com.inconspicuousy.mapstruct.start.model;

import com.inconspicuousy.mapstruct.start.enumation.CarType;
import lombok.*;

/**
 * 汽车类
 * @author peng.yi
 */
@Data
public class Car {

    /** 生产商 */
    private String make;

    /** 汽车座位数 */
    private Integer numberOfSeats;

    /** 汽车类型 */
    private CarType type;



}
