package com.example.demo.repository;

import com.example.demo.domain.internal.ItemLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLabelRepository extends JpaRepository<ItemLabel, Long> {
}
