package controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IBookService;
import util.Constant;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("/manaBook")
    public String manageBook(Integer pageNum, Model model) {
        if (pageNum != null) {
            PageHelper.startPage(pageNum, Constant.MU_PAGE_SIZE);
        } else {
            PageHelper.startPage(1, Constant.MU_PAGE_SIZE);
        }
        List<Book> books = bookService.findAllBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("books", books);
        return "manage/book";
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook(String bookName, String detail, String price, String writer, String printer, String date, String type, String image, Integer store) {
        Book book = new Book();
        book.setBname(bookName);
        book.setDetail(detail);
        book.setPrice(price);
        book.setWriter(writer);
        book.setPrinter(printer);
        book.setDate(date);
        book.setType(type);
        book.setImage(image);
        book.setStore(store);
        bookService.addBook(book);
        return new ModelAndView("redirect:/manaBook.do");
    }

    @RequestMapping("addBookPage")
    public String addBookPage() {
        return "manage/book-add";
    }

    @RequestMapping("/modifyBookPage")
    public String modifyBookPage(Model model, Integer bid) {
        Book book = bookService.findBookById(bid);
        model.addAttribute("book", book);
        return "manage/book-modify";
    }

    @RequestMapping("/modifyBook")
    public ModelAndView manaBook(Integer bid, String bookName, String detail, String price, String writer, String printer, String date, String type, String image, Integer store) {
        Book book = new Book();
        book.setBid(bid);
        book.setBname(bookName);
        book.setDetail(detail);
        book.setPrice(price);
        book.setWriter(writer);
        book.setPrinter(printer);
        book.setDate(date);
        book.setType(type);
        book.setImage(image);
        book.setStore(store);
        bookService.BookModify(book);
        return new ModelAndView("redirect:/manaBook.do");
    }

    @RequestMapping("/delBook")
    public ModelAndView deleteBook(Integer bid) {
        bookService.deleteById(bid);
        return new ModelAndView("redirect:/manaBook.do");
    }

    @RequestMapping("/updateBookPage")
    public String updateBookPage(Model model, HttpSession session) {
        Book sessionBook = (Book) session.getAttribute("book");
        Book book = bookService.findBookById(sessionBook.getBid());
        model.addAttribute("book", book);
        return "front/update";
    }

    @RequestMapping("/updateBook")
    public ModelAndView updateBook(Integer bid, String bookName, String detail, String price, String writer, String printer, String date, String type, String image, Integer store) {
        Book book = new Book();
        book.setBid(bid);
        book.setBname(bookName);
        book.setDetail(detail);
        book.setPrice(price);
        book.setWriter(writer);
        book.setPrinter(printer);
        book.setDate(date);
        book.setType(type);
        book.setImage(image);
        book.setStore(store);
        bookService.BookModify(book);
        return new ModelAndView("redirect:/index.do");
    }
}
