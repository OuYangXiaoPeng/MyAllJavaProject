package mapper;


import domain.BookOrder;
import domain.BookOrderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookOrderMapper {
    long countByExample(BookOrderExample example);

    int deleteByExample(BookOrderExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(BookOrder record);

    int insertSelective(BookOrder record);

    List<BookOrder> selectByExample(BookOrderExample example);

    BookOrder selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") BookOrder record, @Param("example") BookOrderExample example);

    int updateByExample(@Param("record") BookOrder record, @Param("example") BookOrderExample example);

    int updateByPrimaryKeySelective(BookOrder record);

    int updateByPrimaryKey(BookOrder record);
}