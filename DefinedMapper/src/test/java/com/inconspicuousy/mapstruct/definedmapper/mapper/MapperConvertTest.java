package com.inconspicuousy.mapstruct.definedmapper.mapper;

import com.inconspicuousy.mapstruct.definedmapper.dto.CarDto;
import com.inconspicuousy.mapstruct.definedmapper.model.Car;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author peng.yi
 */
public class MapperConvertTest {

    @Test
    public void carToCarDtoTest() {

        Car car = new Car();
        car.setMake("东风公司");
        // car.setName("本田");
        car.setNumberOfSeats(4);

        CarDto carDto = MapperConvert.INSTANCE.carToCarDto(car);
        System.out.println(carDto);
    }
}