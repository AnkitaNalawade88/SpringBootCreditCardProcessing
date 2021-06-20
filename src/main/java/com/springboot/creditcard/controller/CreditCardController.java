package com.springboot.creditcard.controller;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.AccountNotFoundException;
import com.springboot.creditcard.error.CardAlreadyExistException;
import com.springboot.creditcard.error.InvalidCardNoException;
import com.springboot.creditcard.service.CreditCardService;
import com.springboot.creditcard.error.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(CreditCardController.class);

    @PostMapping("/cards")
    public CreditCard addNewCard(@Valid @RequestBody (required = false) CreditCard cc) throws InvalidCardNoException, CardAlreadyExistException {
        LOGGER.info("Inside addNewCard of CreditCardController");
            return creditCardService.save(cc);
    }

    @GetMapping("/cards")
    public List<CreditCard> getCardList() {
        LOGGER.info("Inside getCardList of CreditCardController");
        return creditCardService.getCardList();
    }

    @GetMapping("/cards/{id}")
    public CreditCard findByAccountNo(@PathVariable("id") Long id)
            throws AccountNotFoundException {
        return creditCardService.findByAccountNo(id);
    }
}
