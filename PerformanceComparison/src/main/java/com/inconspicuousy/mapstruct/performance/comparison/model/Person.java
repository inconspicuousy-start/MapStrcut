package com.inconspicuousy.mapstruct.performance.comparison.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author inconspicuousy
 */
@Getter
@Setter
public class Person {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;

}
