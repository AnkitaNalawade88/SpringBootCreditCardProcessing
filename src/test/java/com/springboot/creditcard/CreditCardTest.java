package com.springboot.creditcard;

import com.springboot.creditcard.entity.CreditCard;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CreditCardTest {

    static Validator validator;
    CreditCard card = null;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        card = CreditCard.builder()
                .accountNo(1L)
                .cardNumber("1358954993914435")
                .cardHolderFirstName("ANKITA")
                .cardHolderLastName("NALAWADE")
                .cardLimit(1000L)
                .build();


    }

    @Test
    public void whenNotEmptyCardNumber_thenNoConstraintViolations() {
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        Assert.assertEquals(true, violations.size()==0);
        assertThat(violations.size()).isEqualTo(0);
    }


    @Test
    public void whenNullFirstName_thenOneConstraintViolation() {
        card.setCardHolderFirstName(null);
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        Assert.assertEquals(true, violations.size()>0);

    }


    @Test
    public void whenNullLastName_thenOneConstraintViolation() {
        card.setCardHolderLastName(null);
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        assertThat(violations.size()).isEqualTo(1);

    }

    @Test
    public void whenEmptyCardNumber_thenOneConstraintViolation() {
        card.setCardNumber(null);
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        /*for (ConstraintViolation<CreditCard> v :violations) {
            System.out.println("Message <<< "+v.getMessage());
        }*/
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenCardSizeGreaterThan19_thenOneConstraintViolation() {
        card.setCardNumber("12345678901234567890");
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenCardisNonNumeric_thenOneConstraintViolation() {
        card.setCardNumber("12345678901234567AA");
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenCardHasSpaces_thenOneConstraintViolation() {
        card.setCardNumber("5277 0291 2077 3860");
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void whenCardHasHiphens_thenOneConstraintViolation() {
        card.setCardNumber("4556-0690-9685-2293");
        Set<ConstraintViolation<CreditCard>> violations = validator.validate(card);
        assertThat(violations.size()).isEqualTo(1);
    }
}
