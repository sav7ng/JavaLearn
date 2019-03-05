package com.github.aquanlerou.springbootcache.dao;

import com.github.aquanlerou.springbootcache.entity.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
