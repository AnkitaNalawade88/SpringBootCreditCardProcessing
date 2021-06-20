package com.springboot.creditcard.repository;

import com.springboot.creditcard.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

    CreditCard findByAccountNo(Long accountNo);

}