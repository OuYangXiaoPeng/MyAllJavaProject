package org.example.factory;

import org.example.domain.Book;

public class BookFactory {
    public Book createBook() {
        return new Book();
    }
}
