package 事物处理.编程式事物;


import org.springframework.transaction.TransactionStatus;

import java.util.Optional;

@FunctionalInterface
public interface TransactionUnit<R> {

    Optional<R> execute(TransactionStatus status);
}
