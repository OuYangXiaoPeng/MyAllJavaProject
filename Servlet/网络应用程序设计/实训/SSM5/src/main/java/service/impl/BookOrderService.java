package service.impl;

import domain.BookOrder;
import domain.BookOrderExample;
import mapper.BookOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IBookOrderService;

import java.util.List;

@Service
public class BookOrderService implements IBookOrderService {

    @Autowired
    private BookOrderMapper bookOrderMapper;

    @Override
    public List<BookOrder> findAllBookOrder() {
        BookOrderExample example = new BookOrderExample();
        List<BookOrder> bookOrders = bookOrderMapper.selectByExample(example);
        return bookOrders;
    }

    @Override
    public boolean BookOrderModify(BookOrder bookOrder) {

        BookOrder bo = bookOrderMapper.selectByPrimaryKey(bookOrder.getOid());
        if (bookOrder.getDate() != null && !bookOrder.getDate().equals("")) {
            bo.setDate(bookOrder.getDate());
        }
        if (bookOrder.getOname() != null && !bookOrder.getOname().equals("")) {
            bo.setOname(bookOrder.getOname());
        }
        if (bookOrder.getAddress() != null && !bookOrder.getAddress().equals("")) {
            bo.setAddress(bookOrder.getAddress());
        }
        if (bookOrder.getStatus() != null && !bookOrder.getStatus().equals("")) {
            bo.setStatus(bookOrder.getStatus());
        }
        if (bookOrder.getUid() != null && !bookOrder.getUid().equals("")) {
            bo.setUid(bookOrder.getUid());
        }
        BookOrderExample example = new BookOrderExample();
        BookOrderExample.Criteria cri = example.createCriteria();
        cri.andUidEqualTo(bookOrder.getOid());
        if (bookOrderMapper.updateByExample(bo, example) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public BookOrder findBookOrderById(Integer oid) {
        return bookOrderMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int deleteById(Integer oid) {
        return bookOrderMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public int addBookOrder(BookOrder bookOrder) {
        return bookOrderMapper.insert(bookOrder);
    }
}
