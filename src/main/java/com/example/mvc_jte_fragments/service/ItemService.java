package com.example.mvc_jte_fragments.service;

import com.example.mvc_jte_fragments.entity.Item;
import com.example.mvc_jte_fragments.repository.ItemRepository;

import java.util.NoSuchElementException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Item saveOrUpdate(Item item) {
        return repository.save(item);
    }

    public Item updateById(Long id, Item sourceItem) {
        Item targetItem = findById(id);
        BeanUtils.copyProperties(sourceItem, targetItem, "id"); // Копируем поля, кроме "id"
        return repository.save(targetItem);
    }

    public void deleteById(Long id) {
        Item item = findById(id);
        repository.delete(item);
    }

    public Page<Item> findAll
            (
                    int page, int size, String sortField, String direction
            ) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortField);
        Pageable pageable = PageRequest.of(page-1, size, sort);
        return repository.findAll(pageable);
    }

}
