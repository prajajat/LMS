package com.example.services;

import com.example.componets.DateUtils;
import com.example.dtos.BookDTO;
import com.example.entites.Book;
import com.example.entites.Library;
import com.example.repos.BookRepo;
import com.example.repos.LibraryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService {
    private final BookRepo bookRepo;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public BookService(BookRepo bookRepo,LibraryRepo libraryRepo)
    {
        this.bookRepo=bookRepo;
        this.libraryRepo=libraryRepo;
    }
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private DateUtils dateUtils;

    public Page<Book> getAllBooks (int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookRepo.findAll(pageable);
    }
    public Book getBook(Long Id)
    {
        Book book =bookRepo.findById(Id).orElse(null);
        return book;
    }

    @Transactional
    public Book createBook(BookDTO dto) {
        Library library=libraryRepo.findById(dto.getLibraryId()).orElseThrow(()->new RuntimeException("library not found"));
        Book book=new Book();

        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setLibrary(library);

        return bookRepo.save(book);
    }

}
