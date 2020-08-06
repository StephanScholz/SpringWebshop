package com.sscholz.webshop.controller;

import com.sscholz.webshop.model.ShopItem;
import com.sscholz.webshop.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ShopItemService shopItemService;

    @GetMapping(value = {"/admin", "admin.html"})
    public String admin(Model model) {
        //list with Items
        List<ShopItem> itemList = shopItemService.getItemList();
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

        shopItemService.saveItem(shopItem);

        ModelAndView modelAndView = new ModelAndView("admin");
        return "redirect:/admin";
    }

    //----------- Edit item -----------
    @GetMapping(value = {"/edit", "editItem.html"})
    public String editItem(Model model, @RequestParam(value = "itemId") Integer itemId) {
        ShopItem item = shopItemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "editItem";
    }
    @PostMapping(value = {"/edit", "editItem.html"})
    public String submitEditItem (@ModelAttribute(value = "item") ShopItem shopItem) {

        shopItemService.saveItem(shopItem);

        return "editItem";
    }

    //----------- Delete item -----------
    @GetMapping(value = {"/delete", "deleteItem.html"})
    public String deleteItem(Model model, @RequestParam(value = "itemId") Integer itemId) {
        ShopItem item = shopItemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "deleteItem";
    }
    @PostMapping(value = {"/delete", "deleteItem.html"})
    public String submitDeleteItem (@ModelAttribute(value = "item") ShopItem shopItem) {

        System.out.println("shopItem-ID: "+shopItem.getId());

        shopItemService.deleteItem(shopItem);

        return "redirect:/admin";
    }
}
