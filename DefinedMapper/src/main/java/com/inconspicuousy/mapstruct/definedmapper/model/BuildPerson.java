package com.inconspicuousy.mapstruct.definedmapper.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * @author peng.yi
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BuildPerson {

    private String name;

}
