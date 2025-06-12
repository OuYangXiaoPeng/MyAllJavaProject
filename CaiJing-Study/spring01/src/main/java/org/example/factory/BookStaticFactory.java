package org.example.factory;

import org.example.domain.Book;
//静态
public class BookStaticFactory {
    public static Book createBook() {
        return new Book();
    }
}
