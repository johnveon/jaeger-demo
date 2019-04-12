package com.example.jaegerdemo.trace;

import java.lang.annotation.*;
/**
 *  @Description: 在方法中放上这个注解就可以在jaeger中构根据配置的component=my_java查询到
 *  @Author:zhoufengen
 *  @Date:Created at 2019-04-11 15:34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OwlTrace {
}
