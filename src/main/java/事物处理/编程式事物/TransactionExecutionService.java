package 事物处理.编程式事物;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.reactive.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.validation.ConstraintDeclarationException;
import java.util.Optional;

/**
 * @Author: xuchengrui
 * @Date: 2024/1/30
 * @Description:编程式事物
 **/
public class TransactionExecutionService {
    private static final Logger LOGGER= LoggerFactory.getLogger(TransactionExecutionService.class);

    @Resource
    private TransactionTemplate transactionTemplate;


    public <R> Optional<R> execute(TransactionUnit<R> unit){
        LOGGER.debug("excuting in transaction..");
        return transactionTemplate.execute(transactionStatus -> {
            try {
                return unit.execute(transactionStatus);
            }catch (ConstraintDeclarationException e){
                LOGGER.error("事物执行失败",e);
                transactionStatus.setRollbackOnly();
               throw e;
            }catch (DataAccessException e){
                LOGGER.error("error access database",e);
                transactionStatus.setRollbackOnly();
                throw e;
            }
        });


    }
}
