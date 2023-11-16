package 转换器工具类;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * 配合框架使用的转换器基类
 * @param <Source>
 * @param <Target>
 */
public interface BaseConvert <Source,Target>{

    Target toTarget(Source source);

    @InheritInverseConfiguration
    Source toSource(Target target);

    @InheritConfiguration(name="toTarget")
    List<Target> toTargetList(List<Source> sourceList);

    @InheritConfiguration(name="toSource")
    List<Source> toSourceList(List<Target> targetList);

    default Time map(String time){
        if (StringUtils.isNotEmpty(time)){
            return Time.valueOf(time);
        }
        return null;
    }
    default Long map(Date date){
        if (date!=null){
            return date.getTime();
        }
        return null;
    }
}
