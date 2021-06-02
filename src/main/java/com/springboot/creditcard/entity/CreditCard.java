package com.springboot.creditcard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Pattern(message = "Card Number must be a number", regexp="^[0-9]*$")
    @Size(min = 10, max = 19)
    private String cardNumber;

    @NotNull(message = "First Name cannot be null")
    private String cardHolderFirstName;

    @NotNull(message = "Last Name cannot be null")
    private String cardHolderLastName;

   // @Size(min = 0, max = 10000, message = "cardLimit exceeded")
    private Long cardLimit;

}
