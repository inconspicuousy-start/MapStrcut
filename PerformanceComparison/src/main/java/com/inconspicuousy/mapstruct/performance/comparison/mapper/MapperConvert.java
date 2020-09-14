package com.inconspicuousy.mapstruct.performance.comparison.mapper;

import com.inconspicuousy.mapstruct.performance.comparison.dto.PersonDto;
import com.inconspicuousy.mapstruct.performance.comparison.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author inconspicuousy
 */
@Mapper
public interface MapperConvert {

    MapperConvert INSTANCE = Mappers.getMapper(MapperConvert.class);

    PersonDto personToPersonDto(Person person);

}
