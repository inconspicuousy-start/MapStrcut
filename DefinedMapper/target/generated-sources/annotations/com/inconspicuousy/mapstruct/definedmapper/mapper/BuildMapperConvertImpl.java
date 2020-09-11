package com.inconspicuousy.mapstruct.definedmapper.mapper;

import com.inconspicuousy.mapstruct.definedmapper.dto.BuildPersonDto;
import com.inconspicuousy.mapstruct.definedmapper.dto.BuildPersonDto.BuildPersonDtoBuilder;
import com.inconspicuousy.mapstruct.definedmapper.model.BuildPerson;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-10T19:17:08+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class BuildMapperConvertImpl implements BuildMapperConvert {

    @Override
    public BuildPersonDto fromBuildPerson(BuildPerson person) {
        if ( person == null ) {
            return null;
        }

        BuildPersonDtoBuilder buildPersonDto = BuildPersonDto.builder();

        buildPersonDto.name( person.getName() );

        return buildPersonDto.build();
    }
}
