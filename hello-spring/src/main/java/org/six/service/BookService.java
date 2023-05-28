package org.six.service;

import org.six.entity.Book;
import org.six.repository.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

//    public Book getBookById(Long id) {
//        return bookRepository.findById(id);
//    }


    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
