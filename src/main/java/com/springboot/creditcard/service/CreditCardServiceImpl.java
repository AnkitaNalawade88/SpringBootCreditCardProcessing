package com.springboot.creditcard.service;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.*;
import com.springboot.creditcard.helper.LuhnFormula;
import com.springboot.creditcard.repository.CreditCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    LuhnFormula luhnFormula = null;

    @Override
    public CreditCard save(CreditCard cc) throws InvalidCardNoException, CardAlreadyExistException {
        luhnFormula = new LuhnFormula();

            if (nonNull(cc) && cc.getCardNumber() != null) {
                if(!luhnFormula.validate(cc.getCardNumber())){
                    throw new InvalidCardNoException(cc.getCardNumber() + " is not valid as per luhn algorithm");
                }
            }
        return creditCardRepository.save(cc);
    }

    @Override
    public List<CreditCard> getCardList() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard findByAccountNo(Long accountNo) throws AccountNotFoundException {
        CreditCard found = null;
        log.info("Inside findByAccountNo method"+ accountNo);

        found=creditCardRepository.findByAccountNo(accountNo);

        if(found == null) {
            log.info("Account Not found ");
            throw new AccountNotFoundException("Account ["+accountNo+"] not found");
        }
        return found;
    }
}