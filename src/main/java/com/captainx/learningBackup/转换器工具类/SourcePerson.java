package com.captainx.learningBackup.转换器工具类;

import lombok.*;

import java.util.Date;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/13
 * @Description:转换器原对象
 **/
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SourcePerson {
    private String name;
    private int age;

    private String School;

    private Date birth;
}
