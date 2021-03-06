package com.sscholz.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Service;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "index.html"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
