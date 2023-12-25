package com.captainx.learningBackup.AOP.validation.Response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: captainx
 * @Date: 2023/12/25
 * @Description: 服务端返回的数据
**/
@Setter
@Getter
public class ServiceResponse<T> extends Response {
    private T data;

}
