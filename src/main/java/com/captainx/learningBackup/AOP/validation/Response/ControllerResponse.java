package com.captainx.learningBackup.AOP.validation.Response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author carey
 */
@Setter
@Getter
public class ControllerResponse<T> extends Response {
    private T data;
}
