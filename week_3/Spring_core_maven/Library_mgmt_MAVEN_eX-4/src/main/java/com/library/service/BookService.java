package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class BookService {

    private BookRepository bookRepository;
    private final String serviceName;

    //EXERCISE 7 Constructor for Constructor Injection
     @Autowired
     public BookService(@Value("Library Service v1.0") String serviceName) {
        this.serviceName = serviceName;
        System.out.println("Constructor called with serviceName: " + serviceName);
    }
    //EXERCISE 6
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        //EXERCISE 7
        System.out.println("Setter called to inject BookRepository.");
    }

    public void addBook() {
        System.out.println("[" + serviceName + "] BookService: Adding a book...");
        bookRepository.saveBook();
    }
}
