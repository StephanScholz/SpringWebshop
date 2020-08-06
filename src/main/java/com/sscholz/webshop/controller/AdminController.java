package com.sscholz.webshop.controller;

import com.sscholz.webshop.dao.ShopItemDao;
import com.sscholz.webshop.model.ShopItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ShopItemDao dao;

    @GetMapping(value = {"/admin", "admin.html"})
    public String admin(Model model) {
        //list with Items
        List<ShopItem> itemList = new ArrayList<ShopItem>();
        dao.findAll().iterator().forEachRemaining(itemList::add);
        model.addAttribute("itemList", itemList);
        return "admin";
    }

    //----------- Create new item -----------
    @GetMapping(value = {"/create", "createItem.html"})
    public String createShopItem(Model model) {
        model.addAttribute("item", new ShopItem());
        return "createItem";
    }
    @PostMapping(value = {"/create", "createItem.html"})
    public String submitShopItem (@ModelAttribute(value = "item") ShopItem shopItem) {

        dao.save(shopItem);

        ModelAndView modelAndView = new ModelAndView("admin");
        return "admin";
    }

    //----------- Edit item -----------
    @GetMapping(value = {"/edit", "editItem.html"})
    public String editItem(Model model, @RequestParam(value = "itemId") Integer itemId) {
        ShopItem item = dao.findById(itemId).get();
        model.addAttribute("item", item);
        return "editItem";
    }
    @PostMapping(value = {"/edit", "editItem.html"})
    public String submitEditItem (@ModelAttribute(value = "item") ShopItem shopItem) {

        dao.save(shopItem);

        return "editItem";
    }

    //----------- Delete item -----------
    @GetMapping(value = {"/delete", "deleteItem.html"})
    public String deleteItem(Model model, @RequestParam(value = "itemId") Integer itemId) {
        ShopItem item = dao.findById(itemId).get();
        model.addAttribute("item", item);
        return "deleteItem";
    }
    @PostMapping(value = {"/delete", "deleteItem.html"})
    public String submitDeleteItem (@ModelAttribute(value = "item") ShopItem shopItem) {

        dao.delete(shopItem);

        return "admin";
    }
}
