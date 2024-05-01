package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(name = "getIndex", value = "/")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

}
