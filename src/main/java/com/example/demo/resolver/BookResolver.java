package com.example.demo.resolver;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver {

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public List<Book> books(){
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book book(@Argument Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author){
        System.out.println("Creating book with title: " + title + " and author: " + author);
        Book book = new Book(title, author);
        return bookRepository.save(book);
    }
}
