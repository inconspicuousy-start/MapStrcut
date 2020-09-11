package com.inconspicuousy.mapstruct.definedmapper.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author peng.yi
 */
@Getter
@Setter
// @Accessors(chain = true, fluent = true)
public class PersonDto {

    private String name;

    private Map<String, String> map;
}
