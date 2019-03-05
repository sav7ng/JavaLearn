package com.github.aquanlerou.springbootcache;

import com.github.aquanlerou.springbootcache.dao.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Class AppRunner
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.5 11:28
 * @Version 1.0
 **/
@Component
public class AppRunner implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("..... Fetching Books");
        logger.info("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
        logger.info("isbn-2 -->" + bookRepository.getByIsbn("isbn-2"));
        logger.info("isbn-3 -->" + bookRepository.getByIsbn("isbn-3"));
        logger.info("isbn-4 -->" + bookRepository.getByIsbn("isbn-4"));
        logger.info("isbn-5 -->" + bookRepository.getByIsbn("isbn-5"));
        logger.info("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
        logger.info("isbn-2 -->" + bookRepository.getByIsbn("isbn-2"));
        logger.info("isbn-3 -->" + bookRepository.getByIsbn("isbn-3"));
        logger.info("isbn-4 -->" + bookRepository.getByIsbn("isbn-4"));
        logger.info("isbn-5 -->" + bookRepository.getByIsbn("isbn-5"));
    }


}
