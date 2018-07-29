package com.controllers;

import com.core.services.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    private final static Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String index(Model model){
         model.addAttribute("items", itemService.findAll());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postIndex(){
        logger.info("Post form");
        return "redirect:/";
    }
}
