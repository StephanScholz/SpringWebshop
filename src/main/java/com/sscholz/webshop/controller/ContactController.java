package com.sscholz.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @GetMapping(value = {"/contact", "contact.html"})
    public ModelAndView contact() {
        return new ModelAndView("contact");
    }
    
}
