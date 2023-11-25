package controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import domain.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IBookOrderService;
import util.Constant;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookOrderController {

    @Autowired
    private IBookOrderService bookOrderService;

    @RequestMapping("/manaBookOrder")
    public String manageBookOrder(Integer pageNum, Model model) {
        if (pageNum != null) {
            PageHelper.startPage(pageNum, Constant.MU_PAGE_SIZE);
        } else {
            PageHelper.startPage(1, Constant.MU_PAGE_SIZE);
        }
        List<BookOrder> bookOrders = bookOrderService.findAllBookOrder();
        PageInfo<BookOrder> pageInfo = new PageInfo<BookOrder>(bookOrders);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("bookOrders", bookOrders);
        return "manage/bookOrder";
    }

    @RequestMapping("/addBookOrder")
    public ModelAndView addBookOrder(String date, String oname, String address, String status, Integer uid) {
        BookOrder order = new BookOrder();
        order.setDate(date);
        order.setOname(oname);
        order.setAddress(address);
        order.setStatus(status);
        order.setUid(uid);
        bookOrderService.addBookOrder(order);
        return new ModelAndView("redirect:/manaBookOrder.do");
    }

    @RequestMapping("addBookOrderPage")
    public String addBookOrderPage() {
        return "manage/bookOrder-add";
    }

    @RequestMapping("/modifyBookOrderPage")
    public String modifyBookOrderPage(Model model, Integer oid) {
        BookOrder bookOrder = bookOrderService.findBookOrderById(oid);
        model.addAttribute("bookOrder", bookOrder);
        return "manage/bookOrder-modify";
    }

    @RequestMapping("/modifyBookOrder")
    public ModelAndView manaBookOrder(Integer oid, String date, String oname, String address, String status, Integer uid) {
        BookOrder order = new BookOrder();
        order.setOid(oid);
        order.setDate(date);
        order.setOname(oname);
        order.setAddress(address);
        order.setStatus(status);
        order.setUid(uid);
        bookOrderService.BookOrderModify(order);
        return new ModelAndView("redirect:/manaBookOrder.do");
    }

    @RequestMapping("/delBookOrder")
    public ModelAndView deleteBookOrder(Integer oid) {
        bookOrderService.deleteById(oid);
        return new ModelAndView("redirect:/manaBookOrder.do");
    }

    @RequestMapping("/updateBookOrderPage")
    public String updateBookOrderPage(Model model, HttpSession session) {
        BookOrder sessionBookOrder = (BookOrder) session.getAttribute("bookOrder");
        BookOrder bookOrder = bookOrderService.findBookOrderById(sessionBookOrder.getOid());
        model.addAttribute("bookOrder", bookOrder);
        return "front/update";
    }

    @RequestMapping("/updateBookOrder")
    public ModelAndView updateBookOrder(Integer oid, String date, String oname, String address, String status, Integer uid) {
        BookOrder order = new BookOrder();
        order.setOid(oid);
        order.setDate(date);
        order.setOname(oname);
        order.setAddress(address);
        order.setStatus(status);
        order.setUid(uid);
        bookOrderService.BookOrderModify(order);
        return new ModelAndView("redirect:/index.do");
    }


}
