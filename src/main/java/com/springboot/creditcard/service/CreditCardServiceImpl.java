package com.springboot.creditcard.service;

import com.springboot.creditcard.Helper.CreditCardHelper;
import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.CardAlreadyExistException;
import com.springboot.creditcard.error.CardNotFoundException;
import com.springboot.creditcard.error.InvalidCardNoException;
import com.springboot.creditcard.repository.CreditCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    /*
    @Override
    public CreditCard saveCard(CreditCard cc) throws InvalidCardNoException {

        if(Objects.nonNull(cc)){
            String cardStr = null;

            if(cc.getCardNumber()!=null){
                try {
                    if(!checkIfCardNumberExists(cc)){
                        cardStr = cc.getCardNumber();
                            if (!isValidCreditCardNumber(cardStr)){
                                throw new InvalidCardNoException(cardStr +" is not valid as per luhn algorithm");
                            }
                        }
                } catch (CardAlreadyExistException e) {
                    System.out.println(e.toString());
                }
            }
        }
        return creditCardRepository.save(cc);
    }
    */

    @Override
    public CreditCard saveCard(CreditCard cc) throws CardAlreadyExistException, InvalidCardNoException {

        if (Objects.nonNull(cc)) {
            if (cc.getCardNumber() != null) {
                CreditCard checkIfAlreadyExist = creditCardRepository.findByCardNumber(cc.getCardNumber());

                if (checkIfAlreadyExist != null && checkIfAlreadyExist.getCardNumber() != null) {
                    throw new CardAlreadyExistException("There is already one card with the same no ");
                } else {
                    if (!isValidCreditCardNumber(cc.getCardNumber())) {
                        throw new InvalidCardNoException(cc.getCardNumber() + " is not valid as per luhn algorithm");
                    }
                }
            }
        }
        return creditCardRepository.save(cc);
    }

   /* public boolean checkIfCardNumberExists(CreditCard cc) throws CardAlreadyExistException {
            boolean cardNumberExists = false;

            CreditCard checkIfAlreadyExist = creditCardRepository.findByCardNumber(cc.getCardNumber());
            if (checkIfAlreadyExist != null) {
                cardNumberExists = true;
                throw new CardAlreadyExistException("There is already one card with the same no ");
            }
            return cardNumberExists;
        }
*/

    @Override
    public List<CreditCard> getCardList() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard findByCardNumber(String cardNumber) throws CardNotFoundException {
        CreditCard found = null;
        log.info("Inside findByCardNumber method"+ cardNumber);

        found=creditCardRepository.findByCardNumber(cardNumber);
        log.info("After the Call "+ found);

        if(found == null) {
            throw new CardNotFoundException("Credit Card : ["+ cardNumber + "] Not found");
        }
        return found;
    }

    @Override
    public void deleteCCByCardNumber(String cardNumber) throws CardNotFoundException {

        CreditCard found = null;

        log.info("Inside deleteCCByCardNumber method"+ cardNumber);

        found=creditCardRepository.findByCardNumber(cardNumber);

        log.info("After the Call inside deleteCCByCardNumber "+ found);

        if(found == null) {
            throw new CardNotFoundException("Credit Card : ["+ cardNumber + "] Not found");
        } else {
            creditCardRepository.deleteByCardNumber(cardNumber);
        }
    }

    private static boolean isValidCreditCardNumber(String cardNumber)
    {
        // int array for processing the cardNumber
        int[] cardIntArray=new int[cardNumber.length()];

        for(int i=0;i<cardNumber.length();i++)
        {
            char c= cardNumber.charAt(i);
            cardIntArray[i]=  Integer.parseInt(""+c);
        }

        for(int i=cardIntArray.length-2;i>=0;i=i-2)
        {
            int num = cardIntArray[i];
            num = num * 2;  // step 1
            if(num>9)
            {
                num = num%10 + num/10;  // step 2
            }
            cardIntArray[i]=num;
        }

        int sum = sumDigits(cardIntArray);  // step 3

        System.out.println(sum);

        if(sum%10==0)  // step 4
        {
            return true;
        }
        return false;
    }

    private static int sumDigits(int[] arr)
    {
        return Arrays.stream(arr).sum();
    }
}