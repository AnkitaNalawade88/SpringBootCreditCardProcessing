package com.springboot.creditcard.controller;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.ApiError;
import com.springboot.creditcard.service.CreditCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CreditCardController.class)
class CreditCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditCardService creditCardservice;

    private CreditCard card;

    @BeforeEach
    void setUp() {
        card = CreditCard.builder()
                .accountNo(1L)
                .cardNumber("1358954993914435")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();
    }

    @Test
    public void testSaveCard() throws Exception {
        CreditCard inputcard = CreditCard.builder()
                .accountNo(1L)
                .cardNumber("135895499391443A")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();

        Mockito.when(creditCardservice.saveCard(inputcard))
                .thenReturn(card);

        assertEquals(1000L,inputcard.getCardLimit());
        assertEquals("NALAWADE",inputcard.getCardHolderLastName());
        assertNotNull(inputcard);
        assertEquals(1L, inputcard.getAccountNo());

    }

    @Test
    void fetchCreditCardByCardNumber() throws Exception {
        Mockito.when(creditCardservice.findByCardNumber("1"))
                .thenReturn(card);

        assertEquals("ANKITA", card.getCardHolderFirstName());
        Assertions.assertNotEquals("ANKITATEST", card.getCardHolderFirstName());
    }

    @Test
    void fetchCreditCardByAccountNo() throws Exception {
        Mockito.when(creditCardservice.findByAccountNo(1L))
                .thenReturn(card);

        assertEquals("ANKITA", card.getCardHolderFirstName());
        Assertions.assertNotEquals("ANKITATEST", card.getCardHolderFirstName());
    }

}