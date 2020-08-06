package com.sscholz.webshop.service;

import com.sscholz.webshop.dao.CartItemDao;
import com.sscholz.webshop.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    public List<CartItem> getItemList() {
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        cartItemDao.findAll().iterator().forEachRemaining(cartItemList::add);
        return cartItemList;
    }

    public void saveItem(CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    public CartItem getItemById(Integer cartItemId) {
        Optional<CartItem> optional = cartItemDao.findById(cartItemId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return new CartItem();
        }
    }

    public void deleteItem(CartItem cartItem) {
        cartItemDao.delete(cartItem);
    }

    public CartItem getCartItemByShopItemId(Integer shopItemId) {
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        cartItemDao.findAll().iterator().forEachRemaining(ci -> {
            if (ci.getShopItem().getId() == shopItemId) {
                cartItemList.add(ci);
            }
        });

        if (!cartItemList.isEmpty()) {
            return cartItemList.get(0);
        } else {
            return new CartItem();
        }
    }
}
