package com.example.bookstoreproject.repository;

import com.example.bookstoreproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // SELECT * FROM book b where b.name like '%name% order by name asc';
    @Query(value = "select * from  book b where b.name like concat('%',:name,'%') order by name asc", nativeQuery = true)
    List<Book> findBookByName(@Param("name")String name);
}
