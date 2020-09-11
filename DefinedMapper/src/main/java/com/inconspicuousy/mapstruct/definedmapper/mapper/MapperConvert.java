package com.inconspicuousy.mapstruct.definedmapper.mapper;

import com.inconspicuousy.mapstruct.definedmapper.dto.BuildPersonDto;
import com.inconspicuousy.mapstruct.definedmapper.dto.CarDto;
import com.inconspicuousy.mapstruct.definedmapper.dto.PersonCarDto;
import com.inconspicuousy.mapstruct.definedmapper.dto.PersonDto;
import com.inconspicuousy.mapstruct.definedmapper.model.BuildPerson;
import com.inconspicuousy.mapstruct.definedmapper.model.Car;
import com.inconspicuousy.mapstruct.definedmapper.model.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Mapper 映射器
 * @author peng.yi
 */
// 创建映射器只需要给对应的接口或者抽象类提供一个@Mapper注解即可
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperConvert {

    // 如果采用默认的组件模型, 那么就需要提供一个属性用来接收抽象工厂生成的映射器实现类对象
    MapperConvert INSTANCE = Mappers.getMapper(MapperConvert.class);

    // 默认情况下, 源类型所有的[可读属性]都将被复制到目标类型的相应属性
    // 赋值规则:
    // 1. 当属性名相同时, 它将被隐式赋值(如果数据类型不同, 会先进性类型转换后再进行赋值)
    // 2. 当属性名不同时, 可以通过Mapping注解进行如下转换(如果数据类型不同, 会先进性类型转换后在进行赋值)
    // 类型转换 包含映射器其他的映射方法, 比如Person会自动调用personToPersonDto转成PersonDto对象
    @Mapping(target = "seatCount", source = "numberOfSeats")
    // 这里因为Car中silenceSource属性为流式属性, get方法直接属性名命名, mapstruct获取不到值
    // mapstruct 默认先采用get/set取值或者赋值, 然后没有get/set就会直接用属性进行取值和赋值(属性只能被public修饰, 其他均获取失败)
    @Mapping(target = "silenceTarget", ignore = true)
    // 当使用BeanMapping注解并且 ignoreByDefault 属性为true时, 不会进行隐式赋值, 只有通过Mapping进行显示赋值
    // @BeanMapping(ignoreByDefault = true)
    CarDto carToCarDto(Car car);

    // 注意: 源数据字段必须提供get方法, 不然获取不到数据; 目标数据字段才可以使用fluent类型赋值
    PersonDto personToPersonDto(Person person);

    // 类似于映射方法一样, 我们也可以自定义转换方法, mapstruct在映射属性时,
    // 一旦遇到相同的数据类型参数和返回值就会调用该方法
    default Integer stringToInt(String name) {
        try {
            return Integer.valueOf(name);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 多数据源映射属性到目标数据
     *  注意: 多数据源中如果属性名相同具有歧义, 必须通过Mapping注解进行显示赋值
     */
    @Mapping(target = "name", source = "person.name")
    PersonCarDto personAndCarToPersonCarDto(Person person, Car car);

    /**
     * 多数据源映射属性到目标数据
     * 多数据源可以是非Bean, 普通的数据类型, 数据会直接映射到目标对象属性
     */
    @Mapping(target = "name", source = "name")
    PersonCarDto carToPersonCarDto(String name, Car car);

    /**
     * 可以根据目标对象修改是源对象, 映射的规则和正向映射一致
     *
     * 对于Map属性, 会先将原Map属性清空后, 再填充新的数据
     */
    void updatePersonFromPersonDto(PersonDto personDto, @MappingTarget Person person);






}
