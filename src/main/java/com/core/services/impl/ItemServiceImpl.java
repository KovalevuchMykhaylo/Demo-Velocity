package com.core.services.impl;

import com.core.entity.Item;
import com.core.repositories.ItemRepository;
import com.core.services.ItemService;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final static Logger logger = Logger.getLogger(ItemServiceImpl.class);

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @PostConstruct
    private void createUsers(){
        for(int i = 0; i < 10; i++){
            Item item = new Item();
            item.setName("Name" + i);
            item.setPrice(new BigDecimal(i));
            itemRepository.save(item);
        }
        logger.info("Count of users in data base: " + itemRepository.findAll().size());
    }
}
