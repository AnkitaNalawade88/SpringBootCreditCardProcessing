package com.springboot.creditcard.repository;

import com.springboot.creditcard.entity.CreditCard;
import com.springboot.creditcard.error.CardAlreadyExistException;
import com.springboot.creditcard.error.CardNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class CreditCardDAOImpl implements CreditCardRepository {


    @Override
    public CreditCard findByAccountNo(Long accountNo) {
        return null;
    }

    @Override
    public List<CreditCard> findAll() {
        return null;
    }

    @Override
    public List<CreditCard> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CreditCard> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CreditCard> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(CreditCard creditCard) {

    }

    @Override
    public void deleteAll(Iterable<? extends CreditCard> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    @Transactional(rollbackFor = CardAlreadyExistException.class)
    public <S extends CreditCard> S save(S s) {
        return null;
    }

    @Override
    public <S extends CreditCard> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CreditCard> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CreditCard> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<CreditCard> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CreditCard getOne(String s) {
        return null;
    }

    @Override
    public <S extends CreditCard> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CreditCard> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CreditCard> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CreditCard> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CreditCard> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CreditCard> boolean exists(Example<S> example) {
        return false;
    }
}
