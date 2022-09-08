package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.dto.BookResponseDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.service.BookService;
import com.example.bookstoreproject.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreController {
    @Autowired
    public IBookService bookService;

    @GetMapping("/bookservice")
    public List<Book> getAllBooks() {
        List<Book> bookList= bookService.getAllBooks();
        return bookList;
    }
    @PostMapping("/bookservice")
    public ResponseEntity<BookResponseDTO>createBookData(@RequestBody BookRequestDTO bookRequestDTO){
        Book book = bookService.createBook(bookRequestDTO);
        return new ResponseEntity<BookResponseDTO>(new BookResponseDTO("Inserted book data successfully",book),HttpStatus.OK);
    }

    @GetMapping("bookservice/{bookId}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable("bookId") int bookId){
        Book book = bookService.getBook(bookId);
        return new ResponseEntity<BookResponseDTO>(new BookResponseDTO("Get call for Id successful",book),HttpStatus.OK);

    }
    @PutMapping("/bookservice/{bookId}")
    public ResponseEntity<BookResponseDTO> updateBookById(@PathVariable("bookId")int bookId,@RequestBody BookRequestDTO bookRequestDTO){
        Book book = bookService.updateBook(bookId,bookRequestDTO);
        return new ResponseEntity<BookResponseDTO>(new BookResponseDTO("Updated book data successfully",book),HttpStatus.OK);
    }
    @DeleteMapping("/bookservice/{bookId}")
    public ResponseEntity<BookResponseDTO> deleteByBookId(@PathVariable("bookId") int bookId){
    bookService.deleteBook(bookId);
    return new ResponseEntity<BookResponseDTO>(new BookResponseDTO("Deleted successfully",null),HttpStatus.OK);
    }
}