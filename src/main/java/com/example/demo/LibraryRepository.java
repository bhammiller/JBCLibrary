package com.example.demo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<LibraryBooks, Long>{
    List<LibraryBooks> findByBookavailability(String ln);
}
