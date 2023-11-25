package service.impl;

import domain.Book;
import domain.BookExample;
import mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBook() {
        BookExample example = new BookExample();
        List<Book> books = bookMapper.selectByExample(example);
        return books;
    }

    @Override
    public boolean BookModify(Book book) {

        Book b = bookMapper.selectByPrimaryKey(book.getBid());
        if (book.getBname() != null && !book.getBname().equals("")) {
            b.setBname(book.getBname());
        }
        if (book.getDetail() != null && !book.getDetail().equals("")) {
            b.setDetail(book.getDetail());
        }
        if (book.getPrice() != null && !book.getPrice().equals("")) {
            b.setPrinter(book.getPrice());
        }
        if (book.getWriter() != null && !book.getWriter().equals("")) {
            b.setWriter(book.getWriter());
        }
        if (book.getPrinter() != null && !book.getPrinter().equals("")) {
            b.setPrinter(book.getPrinter());
        }
        if (book.getDate() != null && !book.getDate().equals("")) {
            b.setDate(String.valueOf(book.getDate()));
        }
        if (book.getType() != null && !book.getType().equals("")) {
            b.setType(book.getType());
        }
        if (book.getImage() != null && !book.getImage().equals("")) {
            b.setImage(book.getImage());
        }
        if (book.getStore() != null) {
            b.setStore(book.getStore());
        }
        BookExample example = new BookExample();
        BookExample.Criteria cri = example.createCriteria();
        cri.andBidEqualTo(book.getBid());
        if (bookMapper.updateByExample(b, example) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Book findBookById(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public int deleteById(Integer bid) {
        return bookMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.insert(book);
    }
}
