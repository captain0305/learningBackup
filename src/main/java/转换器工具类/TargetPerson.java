package 转换器工具类;

import lombok.*;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/13
 * @Description:转换器目标对象
 **/
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TargetPerson {

    private String fullName;
    private int years;

    private String school;
    private Long birth;
}
