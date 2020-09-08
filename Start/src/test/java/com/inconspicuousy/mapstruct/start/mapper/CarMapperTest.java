package com.inconspicuousy.mapstruct.start.mapper;
import com.inconspicuousy.mapstruct.start.dto.CarDto;
import com.inconspicuousy.mapstruct.start.enumation.CarType;

import com.inconspicuousy.mapstruct.start.model.Car;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author peng.yi
 */
public class CarMapperTest {

    @Test
    public void carToCarDto() {
        Car car = new Car();
        car.setMake("广汽");
        car.setNumberOfSeats(4);
        car.setType(CarType.SEDAN);

        CarDto carDto = CarMapper.CAR_MAPPER.CarToCarDto(car);
        System.out.println(carDto);
    }
}