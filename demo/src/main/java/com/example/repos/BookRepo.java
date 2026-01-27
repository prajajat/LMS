
package com.example.repos;


import com.example.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<Book,Long> {
    @Query(value = "select b.* from Book b where Id=id",nativeQuery = true)
    Book findById(@Param("id") String vehicleNumber);

}
