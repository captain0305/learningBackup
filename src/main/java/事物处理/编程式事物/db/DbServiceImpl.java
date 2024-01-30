package 事物处理.编程式事物.db;

import 事物处理.编程式事物.TransactionExecutionService;
import 事物处理.编程式事物.db.po.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: xuchengrui
 * @Date: 2024/1/30
 * @Description:数据库服务
 **/
public class DbServiceImpl {

    @Resource
    TransactionExecutionService transactionExecutionService;

    @Resource
    UserMapper userMapper;

    public void save(){
        List<User> users=new ArrayList<>();
        User user1 = new User();
        user1.setName("1");
        User user2 = new User();
        user2.setName("2");

        users.add(new User());
        users.add(user1);
        users.add(user2);
        transactionExecutionService.execute(transactionStatus -> {

            users.stream().forEach(userMapper::insert);
            //保存操作
            return Optional.empty();
        });
    }
}
