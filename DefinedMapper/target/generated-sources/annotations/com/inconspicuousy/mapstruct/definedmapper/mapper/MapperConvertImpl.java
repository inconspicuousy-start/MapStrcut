package com.inconspicuousy.mapstruct.definedmapper.mapper;

import com.inconspicuousy.mapstruct.definedmapper.dto.CarDto;
import com.inconspicuousy.mapstruct.definedmapper.dto.PersonCarDto;
import com.inconspicuousy.mapstruct.definedmapper.dto.PersonDto;
import com.inconspicuousy.mapstruct.definedmapper.model.Car;
import com.inconspicuousy.mapstruct.definedmapper.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-10T19:17:08+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class MapperConvertImpl implements MapperConvert {

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        if ( car.getNumberOfSeats() != null ) {
            carDto.setSeatCount( String.valueOf( car.getNumberOfSeats() ) );
        }
        carDto.setMake( car.getMake() );
        carDto.setName( stringToInt( car.getName() ) );
        carDto.setDriver( personToPersonDto( car.getDriver() ) );
        Set<String> set = car.getSet();
        if ( set != null ) {
            carDto.setSet( new ArrayList<String>( set ) );
        }

        return carDto;
    }

    @Override
    public PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setName( person.getName() );
        Map<String, String> map = person.getMap();
        if ( map != null ) {
            personDto.setMap( new HashMap<String, String>( map ) );
        }

        return personDto;
    }

    @Override
    public PersonCarDto personAndCarToPersonCarDto(Person person, Car car) {
        if ( person == null && car == null ) {
            return null;
        }

        PersonCarDto personCarDto = new PersonCarDto();

        if ( person != null ) {
            personCarDto.setName( person.getName() );
        }
        if ( car != null ) {
            personCarDto.setMake( car.getMake() );
            personCarDto.setNumberOfSeats( car.getNumberOfSeats() );
        }

        return personCarDto;
    }

    @Override
    public PersonCarDto carToPersonCarDto(String name, Car car) {
        if ( name == null && car == null ) {
            return null;
        }

        PersonCarDto personCarDto = new PersonCarDto();

        if ( name != null ) {
            personCarDto.setName( name );
        }
        if ( car != null ) {
            personCarDto.setMake( car.getMake() );
            personCarDto.setNumberOfSeats( car.getNumberOfSeats() );
        }

        return personCarDto;
    }

    @Override
    public void updatePersonFromPersonDto(PersonDto personDto, Person person) {
        if ( personDto == null ) {
            return;
        }

        person.setName( personDto.getName() );
        if ( person.getMap() != null ) {
            Map<String, String> map = personDto.getMap();
            if ( map != null ) {
                person.getMap().clear();
                person.getMap().putAll( map );
            }
            else {
                person.setMap( null );
            }
        }
        else {
            Map<String, String> map = personDto.getMap();
            if ( map != null ) {
                person.setMap( new HashMap<String, String>( map ) );
            }
        }
    }
}
