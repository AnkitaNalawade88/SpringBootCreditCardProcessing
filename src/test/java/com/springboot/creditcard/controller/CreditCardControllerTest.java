package com.springboot.creditcard.controller;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.service.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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
                .cardNumber("135895499391443A")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();


        Mockito.when(creditCardservice.save(inputcard))
                .thenReturn(card);

        mockMvc.perform(post("/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"cardNumber\" : \"4852789106979220268\",\n" +
                        "\t\"cardHolderFirstName\" : \"ANKITA\",\n" +
                        "\t\"cardHolderLastName\" : \"NALAWADE\",\n" +
                        "\t\"cardLimit\" : \"4000\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void testFetchByAccountNo() throws Exception {
        Mockito.when(creditCardservice.findByAccountNo(1L))
                .thenReturn(card);

        mockMvc.perform(get("/cards/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNo").
                        value(card.getAccountNo()));
    }

}