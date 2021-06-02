package com.springboot.creditcard.service;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.AccountNotFoundException;
import com.springboot.creditcard.error.CardAlreadyExistException;
import com.springboot.creditcard.error.CardNotFoundException;
import com.springboot.creditcard.error.InvalidCardNoException;

import java.util.List;

public interface CreditCardService {
    public CreditCard saveCard(CreditCard cc) throws InvalidCardNoException, CardAlreadyExistException;

    public List<CreditCard> getCardList();

    public CreditCard findByCardNumber(String cardNumber) throws CardNotFoundException;

    public void deleteCCByCardNumber(String cardNumber) throws CardNotFoundException;

    public void deleteByAccountNo(Long accountNo) throws AccountNotFoundException;

    public CreditCard findByAccountNo(Long accountNo) throws AccountNotFoundException;

}
