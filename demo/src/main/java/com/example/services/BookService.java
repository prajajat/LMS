package com.example.services;

import com.example.componets.DateUtils;
import com.example.dtos.BookDTO;
import com.example.dtos.FilterDTO;
import com.example.entites.Book;
import com.example.entites.Library;
import com.example.repos.BookRepo;
import com.example.repos.LibraryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService implements IBookservice{
    private final BookRepo bookRepo;

    @PersistenceContext
    private EntityManager entityManager;

    //Constructor Injection
    @Autowired
    public BookService(BookRepo bookRepo)
    {
        this.bookRepo=bookRepo;

    }

    //Field Injection
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private DateUtils dateUtils;

    //getbook have many forms


    public Page<Book> getBook (int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookRepo.findAll(pageable);
    }
    public Book getBook(Long Id)
    {
        Book book =bookRepo.findById(1L).orElse(null);
        return book;
    }




    @Override
    @Transactional
    public Book createBook(BookDTO dto) {
        Library library=libraryRepo.findById(dto.getLibraryId()).orElseThrow(()->new RuntimeException("library not found"));
        Book book=new Book();

        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setLibrary(library);
        book.setAvailable(true);

        return bookRepo.save(book);
    }

   public List<Book> getFilteredBook(FilterDTO filterDTO) {
       Specification<Book> spec = com.example.BookSpecs.withParams(filterDTO);
       List<Book> filteredBooks = bookRepo.findAll((Sort) spec);
       return filteredBooks;

   }
}
