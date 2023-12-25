package com.captainx.learningBackup.AOP.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: captainx
 * @Date: 2023/12/25
 * @Description: 参数验证注解
**/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterValidation {
    // 可以添加一些属性，用于指定校验规则或错误信息
}
