package com.erygindmitri.springlibrary.spring_app_library.repositories;

import com.erygindmitri.springlibrary.spring_app_library.models.Book;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByTitle(String title);
}
