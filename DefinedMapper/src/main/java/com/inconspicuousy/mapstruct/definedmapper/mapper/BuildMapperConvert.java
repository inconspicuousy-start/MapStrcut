package com.inconspicuousy.mapstruct.definedmapper.mapper;

import com.inconspicuousy.mapstruct.definedmapper.dto.BuildPersonDto;
import com.inconspicuousy.mapstruct.definedmapper.model.BuildPerson;
import org.mapstruct.Mapper;

/**
 * @author peng.yi
 */
@Mapper
public interface BuildMapperConvert {

    BuildPersonDto fromBuildPerson(BuildPerson person);

}
