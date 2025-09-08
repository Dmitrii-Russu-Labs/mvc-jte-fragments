package com.example.mvc_jte_fragments.item.repository;

import com.example.mvc_jte_fragments.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}