package com.springboot.creditcard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.LuhnCheck;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNo;

    /**
     *  I have explicitly written luhn formula to check
     *  whether the given card no satisfies  Luhn's Algo
     *  Also we can use @LuhnCheck validation,
     *  this is an alternative way of validating the CARD_NUMBER
     */
    //  @LuhnCheck(message = "CARD NO IS NOT VALID AS PER THE LUHN'S FORMULA")
    @NotBlank(message = "Card number cannot be null or empty")
    @Size(min = 12, max = 19, message = "Please enter a valid card no")
    @Pattern(message = "Card Number must be a number", regexp="^[0-9]*$")
    @Column(name = "CARD_NUMBER", unique = true, nullable = false, length = 19)
    private String cardNumber;


    @NotBlank(message = "First Name cannot be null")
    private String cardHolderFirstName;

    @NotBlank(message = "Last Name cannot be null")
    private String cardHolderLastName;

    @NotNull(message = "Card Limit cannot be null")
    private Long cardLimit = 0L;

}
