package com.validators;

import com.core.entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
public class PostFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Item.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Item item = (Item)o;

        if (item.getName() == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Name can`t be empty");
        }

        if (item.getPrice() == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Price can`t be empty");
        }

        if(item.getName().length()<4){
            errors.rejectValue("name", "Name must be longer then 4 characters");
        }

        if(item.getPrice() != null) {
            if (item.getPrice().compareTo(new BigDecimal(3)) < 0) {
                errors.rejectValue("price", "Price to low");
            }
        }

    }
}
