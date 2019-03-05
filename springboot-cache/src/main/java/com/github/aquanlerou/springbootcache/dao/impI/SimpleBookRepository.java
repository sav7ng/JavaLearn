package com.github.aquanlerou.springbootcache.dao.impI;

import com.github.aquanlerou.springbootcache.dao.BookRepository;
import com.github.aquanlerou.springbootcache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Class SimpleBookRepository
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.5 11:05
 * @Version 1.0
 **/
@Component
public class SimpleBookRepository implements BookRepository {


    @Override
    @Cacheable("book")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some Book~");
    }

    private void simulateSlowService() {
        try {
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
