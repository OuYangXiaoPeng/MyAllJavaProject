package service;

import domain.BookOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IBookOrderService {

    List<BookOrder> findAllBookOrder();

    boolean BookOrderModify(BookOrder bookOrder);

    BookOrder findBookOrderById(Integer oid);

    int deleteById(Integer oid);

    int addBookOrder(BookOrder bookOrder);

}
