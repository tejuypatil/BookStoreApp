package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.exception.InvalidTokenException;
import com.example.bookstoreproject.repository.BookRepository;
import com.example.bookstoreproject.repository.UserRepository;
import com.example.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    public BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Book> getAllBooks()
    {
        List<Book> bookList = bookRepository.findAll();
        if (bookList.isEmpty()){
            return null;
        }
        return bookList;
    }

    @Override
    public Book createBook(String token,BookRequestDTO bookRequestDTO) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            Book book = new Book(bookRequestDTO);
            return bookRepository.save(book);
        }
        else {
            throw new InvalidTokenException(token);
        }
    }

    @Override
    public Book getBook(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book updateBook(int bookId, BookRequestDTO bookRequestDTO) {
        Book book = this.getBook(bookId);
        book.setName(bookRequestDTO.name);
        book.setAuthor(bookRequestDTO.author);
        return bookRepository.save(book);
    }
    @Override
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
