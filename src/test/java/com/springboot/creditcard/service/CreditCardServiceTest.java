package com.springboot.creditcard.service;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreditCardServiceTest {

    @Autowired
    private CreditCardService creditCard;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @BeforeEach
    void setUp() {
        CreditCard card = CreditCard.builder()
                .cardNumber("1358954993914435")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();

        Mockito.when(creditCardRepository.findByCardNumber("1"))
                .thenReturn(card);

    }

    @Test
    @DisplayName("FetchBy CardNumber testcase")
    public void testFetchByCardNumber() {

        CreditCard found =
                creditCardRepository.findByCardNumber("1");

        assertEquals("1358954993914435", found.getCardNumber());
    }
}