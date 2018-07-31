package com.controllers;

import com.core.entity.Item;
import com.validators.PostFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MyRestController {

    private final static Logger logger = Logger.getLogger(RestController.class);

    private PostFormValidator postFormValidator;

    @Autowired
    public MyRestController(PostFormValidator postFormValidator) {
        this.postFormValidator = postFormValidator;
    }

    @InitBinder("item")
    protected void addValidator(WebDataBinder binder){
        binder.addValidators(postFormValidator);
    }

    @RequestMapping(value = "/restForm", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ResponseEntity restPostForm(@RequestParam("sname") String sname, @Valid Item item,
                                       BindingResult bindingResult) throws NoSuchMethodException, MethodArgumentNotValidException {
        logger.info("post form");
        if(bindingResult.hasErrors()) {
            logger.info("invalid post form");
            throw new MethodArgumentNotValidException(new MethodParameter(this.getClass().getDeclaredMethod("restPostForm",
                    String.class, Item.class, BindingResult.class), 1), bindingResult);
        }

        logger.info("Item name: " + item.getName());
        logger.info("Item price: " + item.getPrice());
        logger.info("Sname: " + sname);
        return ResponseEntity.ok().build();
    }
}
