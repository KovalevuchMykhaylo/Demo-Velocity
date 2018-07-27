package com.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.core.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
