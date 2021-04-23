package com.example.demo.repository;

import com.example.demo.domain.internal.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByType(String type);
    List<Item> findByValue(String value);
    List<Item> findByTypeAndValue(String type, String value);
}
