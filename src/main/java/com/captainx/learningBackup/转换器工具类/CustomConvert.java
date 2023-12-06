package com.captainx.learningBackup.转换器工具类;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;



/**
 * @Author: captainx
 * @Date: 2023/11/13
 * @Description: 用于框架中的转换器
**/

public interface CustomConvert {

    PersonConvert personConvert=Mappers.getMapper(PersonConvert.class);

    @Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
    interface PersonConvert extends BaseConvert<SourcePerson,TargetPerson>{

        @Mappings({
                @Mapping(source = "name",target = "fullName"),
                @Mapping(source = "age",target = "years")
        })
        @Override
        TargetPerson toTarget(SourcePerson sourcePerson);
        @Mappings({
                @Mapping(source = "fullName",target = "name"),
                @Mapping(source = "years",target = "age")
        })
        @Override
        SourcePerson toSource(TargetPerson targetPerson);
    }

}
