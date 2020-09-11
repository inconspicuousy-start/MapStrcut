package com.inconspicuousy.mapstruct.definedmapper.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author peng.yi
 */
@Getter
@Setter
public class CarDto {

    private String make;
    private Integer name;
    private String seatCount;
    private String silenceTarget;
    private PersonDto driver;
    private List<String> set;


}
