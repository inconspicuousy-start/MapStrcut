package com.inconspicuousy.mapstruct.start.mapper;

import com.inconspicuousy.mapstruct.start.dto.CarDto;
import com.inconspicuousy.mapstruct.start.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Car 实体映射成 CarDto 工具类
 * @author peng.yi
 */
@Mapper
public interface CarMapper {

    // mapstruct主要做了两件事
    // 1、在编译期间根据注解生成对应的MapperImpl实现类
    // 2、在运行期间 Mappers.getMapper 找到对应的MapperImpl实现类
    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    // 相同属性名， 相同数据类型， 不需要配置直接进行赋值
    // 相同属性名， 数据类型为枚举的话会自动转化成字符串型
    // 不同属性名需要借用Mapping注解进行转化
    @Mapping(target = "seatCount", source = "numberOfSeats")
    CarDto CarToCarDto(Car car);

}
