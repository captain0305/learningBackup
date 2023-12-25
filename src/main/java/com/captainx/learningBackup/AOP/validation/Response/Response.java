package com.captainx.learningBackup.AOP.validation.Response;

import com.captainx.learningBackup.AOP.validation.Enums.ResponsEums;
import lombok.Data;

/**
 * @Author: captainx
 * @Date: 2023/12/25
 * @Description: 返回
**/
@Data
public class Response {
    public String code;
    public String message;
    public void fail(){
        this.code=ResponsEums.Faliure.getCode();
        this.message=ResponsEums.Faliure.getMsg();
    }
    public void success(){
        this.code=ResponsEums.Success.getCode();
        this.message=ResponsEums.Success.getMsg();
    }

}
