package com.inconspicuousy.mapstruct.definedmapper.mapper;

import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author peng.yi
 */
public class DynamicCompilerTest {

    @Test
    public void test() {
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(systemJavaCompiler);
    }
}
