
package com.example.repos;


import com.example.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book,Long> {

    //jpql
    @Query(value = "select b from Book b where b.Id=id", nativeQuery=false)
    Book findById2(@Param("id") Long id);


    //native
    @Query(value = "select b.* from books b where b.title=title", nativeQuery=true)
    Book findByTitle(@Param("title") String title);


}