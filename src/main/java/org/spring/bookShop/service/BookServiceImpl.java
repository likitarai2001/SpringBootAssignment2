package org.spring.bookShop.service;

import org.spring.bookShop.entities.Book;
import org.spring.bookShop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public int updateBook(Book book){
        Optional<Book> bookObj = bookRepository.findById(book.getId());
        if(bookObj.isEmpty()){
            return 0;
        }
        return bookRepository.updateBook(book.getTitle(), book.getAuthor(), book.getPrice(), book.getId());
    }

    @Override
    public int updateBookPrice(int id, int price){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return 0;
        }
        return bookRepository.updateBookPrice(id, price);
    }

    @Override
    public int deleteBook(int id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            return 0;
        }
        bookRepository.deleteById(id);
        return 1;
    }
}
