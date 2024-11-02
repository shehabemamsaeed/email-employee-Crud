package com.example.ass2.repo;

import com.example.ass2.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepo extends JpaRepository<Email,Long> {


    Email findByName(String name);

    List<Email> findAllByNameIn(List<String> name);

    Email findByContent(String content);
}
