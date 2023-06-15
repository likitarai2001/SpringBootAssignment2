package org.spring.bookShop.controller;

import org.spring.bookShop.entities.Book;
import org.spring.bookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBookDetails(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getSpecificBookDetails(@PathVariable("id") int id){
        return bookService.getBook(id);
    }

    @PostMapping("/")
    public String addBookDetails(@RequestBody Book book){
        bookService.addBook(book);
        return "Book added successfully";
    }

    @PutMapping("/")
    public String updateBookDetails(@RequestBody Book book){
        int rowsAffected = bookService.updateBook(book);
        return (rowsAffected > 0) ? "Book updated successfully" : "Book with id = " + book.getId() + " doesn't exist";
    }

    @PatchMapping("/")
    public String updateBookPrice(@RequestParam("id") String id, @RequestParam("price") String price){
        int bookId =  Integer.parseInt(id);
        int bookPrice = Integer.parseInt(price);

        int rowsAffected = bookService.updateBookPrice(bookId, bookPrice);
        System.out.println("affected book price "+ rowsAffected);
        return (rowsAffected > 0) ? "Price updated successfully" : "Book with id = " + id + " doesn't exist";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") String id){
        int bookId =  Integer.parseInt(id);
        int rowsAffected = bookService.deleteBook(bookId);
        return (rowsAffected > 0) ? "Book deleted successfully" : "Book with id = " + id + " doesn't exist";
    }


}
