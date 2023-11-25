package service;

import domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IBookService {

    List<Book> findAllBook();

    boolean BookModify(Book book);

    Book findBookById(Integer bid);

    int deleteById(Integer bid);

    int addBook(Book book);

}
