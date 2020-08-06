package com.sscholz.webshop.controller;

import com.sscholz.webshop.dao.ShopItemDao;
import com.sscholz.webshop.model.ShopItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebshopController {

    @Autowired
    private ShopItemDao dao;

    @GetMapping(value = {"/shop", "shop.html"})
    public String shop(Model model) {
        //list with Items
        List<ShopItem> itemList = new ArrayList<ShopItem>();
        dao.findAll().iterator().forEachRemaining(itemList::add);
        model.addAttribute("itemList", itemList);

        return "shop";
    }

}
