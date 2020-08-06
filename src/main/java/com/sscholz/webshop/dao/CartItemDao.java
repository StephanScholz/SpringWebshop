package com.sscholz.webshop.dao;

import com.sscholz.webshop.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemDao extends CrudRepository<CartItem, Integer> {
}
