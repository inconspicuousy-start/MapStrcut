package com.inconspicuousy.mapstruct.compilerargs;

import com.inconspicuousy.mapstruct.compilerargs.conf.Configuration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author peng.yi
 */
public class CarMapperTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        // 注意, 这里是直接将映射器实现类存到Spring容器而不是映射器抽象类或者接口
        System.out.println(applicationContext.getBean("carMapperImpl"));

    }
}
