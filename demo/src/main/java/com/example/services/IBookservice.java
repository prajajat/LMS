package com.example.services;

import com.example.dtos.BookDTO;
import com.example.entites.Book;

public interface IBookservice {
    Book createBook(BookDTO dto);
}
