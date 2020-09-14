package com.inconspicuousy.mapstruct.performance.comparison.dto;
import java.util.Arrays;
import java.util.Date;

import com.inconspicuousy.mapstruct.performance.comparison.mapper.MapperConvert;
import com.inconspicuousy.mapstruct.performance.comparison.model.Person;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationTargetException;

/**
 * @author inconspicuousy
 */
public class PersonDtoTest {

    /**
     * 计算利用MapStruct来映射实体类的时间
     * @param person
     * @param times 映射的次数
     */
    public void mappingByMapStruct(Person person, int times) {
        // 利用StopWatch计算核心算法的计算时间
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < times; i++) {
            PersonDto personDto = MapperConvert.INSTANCE.personToPersonDto(person);
        }

        stopWatch.stop();
        System.out.println("PersonDtoTest.mappingByMapStruct cost: " + stopWatch.getTotalTimeMillis());
    }

    /**
     * 计算利用SpringBeanUtils来映射实体类的时间
     * @param person
     * @param times 映射的次数
     */
    public void mappingBySpringBeanUtils(Person person, int times) {
        // 利用StopWatch计算核心算法的计算时间
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < times; i++) {
            PersonDto personDto = new PersonDto();
            BeanUtils.copyProperties(person, personDto);
        }

        stopWatch.stop();
        System.out.println("PersonDtoTest.mappingBySpringBeanUtils cost: " + stopWatch.getTotalTimeMillis());
    }

    /**
     * 计算利用CglibBean来映射实体类的时间
     * @param person
     * @param times 映射的次数
     */
    public void mappingByCglibBeanCopier(Person person, int times) {
        // 利用StopWatch计算核心算法的计算时间
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < times; i++) {
            PersonDto personDto = new PersonDto();
            BeanCopier beanCopier = BeanCopier.create(Person.class, PersonDto.class, false);
            beanCopier.copy(person, personDto, null);
        }

        stopWatch.stop();
        System.out.println("PersonDtoTest.mappingByCglibBeanCopier cost: " + stopWatch.getTotalTimeMillis());
    }

    /**
     * 计算利用ApacheBeanUtils来映射实体类的时间
     * @param person
     * @param times 映射的次数
     */
    public void mappingByApacheBeanUtils(Person person, int times) throws InvocationTargetException, IllegalAccessException {
        // 利用StopWatch计算核心算法的计算时间
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 0; i < times; i++) {
            PersonDto personDto = new PersonDto();
            org.apache.commons.beanutils.BeanUtils.copyProperties(personDto, person);
        }

        stopWatch.stop();
        System.out.println("PersonDtoTest.mappingByApacheBeanUtils cost: " + stopWatch.getTotalTimeMillis());
    }

    @Test
    public void test() {
        Person person = new Person();
        person.setId(1);
        person.setName("inconspicuousy");
        person.setAge(28);
        person.setBirthday(new Date());

        Arrays.asList(1, 100, 1000, 10000, 100000).forEach(times -> {
            System.out.println("========================");
            System.out.println("times = " + times);
            mappingByMapStruct(person, times);
            mappingBySpringBeanUtils(person, times);
            mappingByCglibBeanCopier(person, times);
            try {
                mappingByApacheBeanUtils(person, times);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });



    }
}