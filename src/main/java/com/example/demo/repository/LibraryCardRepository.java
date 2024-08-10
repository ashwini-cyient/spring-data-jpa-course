package com.example.demo.repository;

import com.example.demo.entitiy.LibraryCard;
import org.springframework.data.repository.CrudRepository;

public interface LibraryCardRepository extends CrudRepository<LibraryCard, Long> {
}
