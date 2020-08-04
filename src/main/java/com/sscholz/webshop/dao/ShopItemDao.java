package com.sscholz.webshop.dao;

import com.sscholz.webshop.model.ShopItem;
import org.springframework.data.repository.CrudRepository;

public interface ShopItemDao extends CrudRepository<ShopItem, Integer> {
}
