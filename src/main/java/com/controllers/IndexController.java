package com.controllers;

import com.core.entity.Item;
import com.core.services.ItemService;
import com.validators.PostFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
public class IndexController {

    private final static Logger logger = Logger.getLogger(IndexController.class);

    private ItemService itemService;

    private PostFormValidator postValidator;

    @Autowired
    public IndexController(ItemService itemService, PostFormValidator postValidator) {
        this.itemService = itemService;
        this.postValidator = postValidator;
    }

    @InitBinder("restPostForm")
    protected void addValidator(WebDataBinder binder){
        binder.setValidator(postValidator);
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postIndex() {
        logger.info("Post form");
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/restForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity restPostForm(@Valid Item item,
                                       BindingResult bindingResult) throws NoSuchMethodException, MethodArgumentNotValidException {
            logger.info("post form");
        if(bindingResult.hasErrors()) {
            logger.info("invalid post form");
            throw new MethodArgumentNotValidException(new MethodParameter(this.getClass().getDeclaredMethod("restPostForm",
                    Item.class, BindingResult.class), 0), bindingResult);
        }

        logger.info("Item name: " + item.getName());
        logger.info("Item price: " + item.getPrice());
        return ResponseEntity.ok().build();
    }
}

