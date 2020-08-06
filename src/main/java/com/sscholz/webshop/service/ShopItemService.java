package com.sscholz.webshop.service;

import com.sscholz.webshop.dao.ShopItemDao;
import com.sscholz.webshop.model.ShopItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopItemService {

    @Autowired
    ShopItemDao shopItemDao;

    /**
     * Find a ShopItem in the database.
     * @param itemId Id of the ShopItem in question
     * @return ShopItem if found in db, new ShopItem if not
     */
    public ShopItem getItemById(Integer itemId) {
        Optional<ShopItem> optional = shopItemDao.findById(itemId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return new ShopItem();
        }
    }

    /**
     * Gets a full list of all ShopItems
     * @return a full list of all saved ShopItems
     */
    public List<ShopItem> getItemList() {
        List<ShopItem> itemList = new ArrayList<ShopItem>();
        shopItemDao.findAll().iterator().forEachRemaining(itemList::add);
        return itemList;
    }

    /**
     * Saves a ShopItem in the database
     * @param shopItem the ShopItem to save
     */
    public void saveItem(ShopItem shopItem) {
        shopItemDao.save(shopItem);
    }

    /**
     * Deletes a ShopItem from the database
     * @param shopItem the ShopItem to delete
     */
    public void deleteItem(ShopItem shopItem) {
        shopItemDao.delete(shopItem);
    }
}
