package org.six;

import org.six.config.DatabaseConfig;
import org.six.entity.Book;
import org.six.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        BookService bookService = context.getBean(BookService.class);
        Book book = new Book();
        book.setAuthor("ABC");
        book.setTitle("DEF");
        bookService.saveBook(book);
//        bookService.getAllBooks();

        context.close();

    }

}
