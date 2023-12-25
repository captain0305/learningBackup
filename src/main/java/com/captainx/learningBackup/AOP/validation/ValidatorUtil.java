package com.captainx.learningBackup.AOP.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: captainx
 * @Date: 2023/12/25
 * @Description: 参数验证工具类
**/
public class ValidatorUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验对象并返回错误信息
     * 键：属性名  值：错误信息
     **/
    public static Map<String, String> validate(@Valid Object obj) {
        Map<String, String> validatedMsg = new HashMap<>();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
        for (ConstraintViolation<Object> c : constraintViolations) {
            validatedMsg.put(c.getPropertyPath().toString(), c.getMessage());
        }
        return validatedMsg;
    }
}
