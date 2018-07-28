package com.core.services;

import com.core.entity.Item;

import java.util.List;

public interface ItemService {

    void save (Item item);

    List<Item> findAll();
}
