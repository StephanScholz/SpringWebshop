package com.sscholz.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebshopController {

    @GetMapping(value = {"/shop", "shop.html"})
    public ModelAndView shop() {
        return new ModelAndView("shop");
    }

}
