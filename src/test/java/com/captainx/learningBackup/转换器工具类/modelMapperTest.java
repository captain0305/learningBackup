package com.captainx.learningBackup.转换器工具类;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.Date;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/13
 * @Description:modelMapper功能测试
 **/
public class modelMapperTest {

    @Test
    public void testModelMapper(){
        SourcePerson sourcePerson=new SourcePerson();
        sourcePerson.setName("Jhon");
        sourcePerson.setAge(23);
        sourcePerson.setSchool("bupt");
        sourcePerson.setBirth(new Date());
        ModelMapper modelMapper=new ModelMapper();

        TargetPerson map = modelMapper.map(sourcePerson, TargetPerson.class);
        System.out.println(map);
    }
    @Test
    public void testModelMapper2(){
        SourcePerson sourcePerson=new SourcePerson();
        sourcePerson.setName("Jhon");
        sourcePerson.setAge(23);
        sourcePerson.setSchool("bupt");
        sourcePerson.setBirth(new Date());
        ModelMapper modelMapper=new ModelMapper();
        // 自定义映射规则（可选）
        PropertyMap<SourcePerson, TargetPerson> customMapping = new PropertyMap<SourcePerson, TargetPerson>() {
            protected void configure() {
                map().setFullName(source.getName());
                map().setYears(source.getAge());
            }
        };
        modelMapper.addMappings(customMapping);
        TargetPerson map = modelMapper.map(sourcePerson, TargetPerson.class);


        System.out.println(map);
    }

    @Test
    public void testModelMapperWithConvertor(){
        SourcePerson sourcePerson=new SourcePerson();
        sourcePerson.setName("Jhon");
        sourcePerson.setAge(23);
        sourcePerson.setSchool("bupt");
        sourcePerson.setBirth(new Date());
        ModelMapper modelMapper=new ModelMapper();
        // 自定义映射规则（可选）
        CustomConvertor customConvertor=new CustomConvertor();

        modelMapper.addConverter(customConvertor);
        TargetPerson map = modelMapper.map(sourcePerson, TargetPerson.class);


        System.out.println("target:"+map);
        System.out.println("source"+sourcePerson);
    }
}
