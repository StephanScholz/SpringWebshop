package com.sscholz.webshop.controller;

import com.sscholz.webshop.dao.ShopItemDao;
import com.sscholz.webshop.model.ShopItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private ShopItemDao dao;

    @GetMapping(value = {"/admin", "admin.html"})
    public String admin(Model model) {
        model.addAttribute("item", new ShopItem());
        return "admin";
    }

    @PostMapping(value = {"/create", "admin.html"})
    public String submitShopItem (@ModelAttribute(value = "item") ShopItem shopItem) {

        dao.save(shopItem);

        ModelAndView modelAndView = new ModelAndView("admin");
        return "admin";
    }
}
