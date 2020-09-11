package com.inconspicuousy.mapstruct.compilerargs.mapper;

import com.inconspicuousy.mapstruct.compilerargs.dto.CarDto;
import com.inconspicuousy.mapstruct.compilerargs.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author peng.yi
 */
// Mapper注解配置了componentModel属性, 该属性的优先级高于maven的编译参数defaultComponentModel配置
// Mapper注解配置了unmappedTargetPolicy属性, 该属性的优先级高于maven的编译参数unmappedTargetPolicy配置
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarMapper {

    // CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    CarDto carToCarDto(Car car);


}
