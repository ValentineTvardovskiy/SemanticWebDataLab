package com.example.demo.repository;

import com.example.demo.domain.internal.ItemLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemLabelRepository extends JpaRepository<ItemLabel, Long> {

    List<ItemLabel> findByType(String type);
    List<ItemLabel> findByValue(String value);
    List<ItemLabel> findByLang(String lang);
    ItemLabel findByItemId(Long itemId);
}
