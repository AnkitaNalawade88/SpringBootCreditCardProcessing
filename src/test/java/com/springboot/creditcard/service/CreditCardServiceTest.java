package com.springboot.creditcard.service;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.AccountNotFoundException;
import com.springboot.creditcard.error.CardAlreadyExistException;
import com.springboot.creditcard.error.InvalidCardNoException;
import com.springboot.creditcard.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditCardServiceTest {
    CreditCard card = new CreditCard();

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    CreditCardRepository dao;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @BeforeEach
    void setUp() {
        card = CreditCard.builder()
                .accountNo(1L)
                .cardNumber("1358954993914435")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();

        when(creditCardRepository.findByAccountNo(1L))
                .thenReturn(card);

        when(creditCardRepository.save(card))
                .thenReturn(card);

    }

    @Test
    @DisplayName("FetchBy AccountNo testcase")
    public void testFetchByAccountNo() throws AccountNotFoundException {

        CreditCard found =
                creditCardService.findByAccountNo(1L);

        assertEquals("1358954993914435", found.getCardNumber());
        assertEquals(1L, found.getAccountNo());
        assertEquals("ANKITA", found.getCardHolderFirstName());

        verify(dao, times(1)).findByAccountNo(1L);

    }
////////////////////////////////////////////
    @Test
    @DisplayName("SAVE CARD TESTCASE")
    public void testSaveCard() throws AccountNotFoundException, CardAlreadyExistException, InvalidCardNoException {

        CreditCard result =null;
        result = creditCardService.save(card);

        assertEquals("1358954993914435", result.getCardNumber());
        assertEquals(1L, result.getAccountNo());
        assertEquals("ANKITA", result.getCardHolderFirstName());

        verify(dao, times(1)).save(card);
    }
}