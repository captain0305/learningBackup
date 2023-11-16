package 转换器工具类;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/13
 * @Description:转换器设置
 **/
public class CustomConvertor implements Converter<SourcePerson, TargetPerson> {


    @Override
    public TargetPerson convert(MappingContext<SourcePerson, TargetPerson> mappingContext) {
        SourcePerson source = mappingContext.getSource();

        // 进行自定义的转换逻辑
        TargetPerson target = new TargetPerson();
        target.setFullName(source.getName());
        target.setYears(source.getAge());

        return target;
    }



}
