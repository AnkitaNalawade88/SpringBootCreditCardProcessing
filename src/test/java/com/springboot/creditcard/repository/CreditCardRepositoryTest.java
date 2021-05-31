package com.springboot.creditcard.repository;

import com.springboot.creditcard.entity.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CreditCardRepositoryTest {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        CreditCard card = CreditCard.builder()
                .cardNumber("1358954993914435")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();

        entityManager.persist(card);
    }

    @Test
    public void whenFindByCardNo_thenCreditCard() {
        //CreditCard cc = creditCardRepository.findById("1358954993914435").get();
        //assertEquals(cc.getCardNumber(), "1358954993914435");

    }
}