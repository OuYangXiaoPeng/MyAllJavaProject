package org.example.factory;

import org.example.domain.Book;
import org.springframework.beans.factory.FactoryBean;

//必须实现FactoryBean接口
public class BookFactoryBean implements FactoryBean<Book> {
    /*
    SpringIOC容器创建bean+调用的方法
     */
    @Override
    public Book getObject() throws Exception {
        return new Book();
    }

    /*
    要创建的javabean的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }
}
